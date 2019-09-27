package com.example.elite.arhub;

import android.net.Uri;
import android.util.Log;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.rendering.ModelRenderable;

import java.lang.ref.WeakReference;

public class ModelLoader {
    private static final String TAG = "ModelLoader";
    private final WeakReference<FragmentAr> owner;

    ModelLoader(WeakReference<FragmentAr> owner) {
        this.owner = owner;
    }

    void loadModel(Anchor anchor, Uri uri) {
        if (owner.get() == null) {
            Log.d(TAG, "Activity is null.  Cannot load model.");
            return;
        }
        ModelRenderable.builder()
                .setSource(owner.get(), uri)
                .build()
                .handle((renderable, throwable) -> {
                    FragmentAr activity = owner.get();
                    if (activity == null) {
                        return null;
                    } else if (throwable != null) {
                        activity.onException(throwable);
                    } else {
                        activity.addNodeToScene(anchor, renderable);
                    }
                    return null;
                });

    }
}