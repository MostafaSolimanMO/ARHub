package com.example.elite.arhub;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Trackable;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.lang.ref.WeakReference;
import java.util.List;

public class FragmentAr extends AppCompatActivity {
    private ArFragment arFragment;
    private ModelLoader modelLoader;
    private String UriFromActivities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_ar);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);

        arFragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> arFragment.onUpdate(frameTime));
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
             UriFromActivities = extras.getString("URI");
        }
        modelLoader = new ModelLoader(new WeakReference<>(this));
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> addObject(Uri.parse(UriFromActivities)));
    }

    private android.graphics.Point getScreenCenter() {
        View vw = findViewById(android.R.id.content);
        return new android.graphics.Point(vw.getWidth()/2, vw.getHeight()/2);
    }
    private void addObject(Uri model) {
        Frame frame = arFragment.getArSceneView().getArFrame();
        android.graphics.Point pt = getScreenCenter();
        List<HitResult> hits;
        if (frame != null) {
            hits = frame.hitTest(pt.x, pt.y);
            for (HitResult hit : hits) {
                Trackable trackable = hit.getTrackable();
                if (trackable instanceof Plane &&
                        ((Plane) trackable).isPoseInPolygon(hit.getHitPose())) {
                    modelLoader.loadModel(hit.createAnchor(), model);
                    break;

                }
            }
        }
    }
    public void addNodeToScene(Anchor anchor, ModelRenderable renderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setRenderable(renderable);
        node.setParent(anchorNode);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        node.select();
        startAnimation(node, renderable);
    }
    public void onException(Throwable throwable){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(throwable.getMessage())
                .setTitle("error!");
        AlertDialog dialog = builder.create();
        dialog.show();
        return;
    }
    public void startAnimation(TransformableNode node, ModelRenderable renderable) {
        if (renderable == null || renderable.getAnimationDataCount() == 0) {
            return;
        }
        for (int i = 0; i < renderable.getAnimationDataCount(); i++) {
            AnimationData animationData = renderable.getAnimationData(i);
        }
        ModelAnimator animator = new ModelAnimator(renderable.getAnimationData(0), renderable);
        animator.start();
        node.setOnTapListener(
                (hitTestResult, motionEvent) -> {
                    togglePauseAndResume(animator);
                });
    }

    public void togglePauseAndResume(ModelAnimator animator) {
        if (animator.isPaused()) {
            animator.resume();
        } else if (animator.isStarted()) {
            animator.pause();
        } else {
            animator.start();
        }
    }
}
