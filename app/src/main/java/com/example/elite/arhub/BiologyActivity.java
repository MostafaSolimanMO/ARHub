package com.example.elite.arhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BiologyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);

        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.cow_png, "Cow"
                , "A cow is a large female animal that is kept on farms for its milk. People sometimes refer to male and female animals of this species as cows."
                , "cow.sfb"));
        assets.add(new Asset(R.drawable.dolphin_png, "dolphin"
                , "Dolphins are aquatic mammals that belong to the infraorder “Cetacea” a group of animals that includes whales, dolphins, and porpoises. They also belong to the parvorder “Odontoceti,” which are the toothed cetaceans, but taxonomically speaking, dolphins are an informal group, composed by most toothed cetaceans but excluding whales and porpoises."
                , "dolphin.sfb"));
        assets.add(new Asset(R.drawable.elephant_png, "elephant"
                , "Elephant, (family Elephantidae), largest living land animal, characterized by its long trunk (elongated upper lip and nose), columnar legs, and huge head with temporal glands and wide, flat ears. Elephants are grayish to brown in colour, and their body hair is sparse and coarse. They are found most often in savannas, grasslands, and forests but occupy a wide range of habitats, including deserts, swamps, and highlands in tropical and subtropical regions of Africa and Asia."
                , "elephant.sfb"));
        assets.add(new Asset(R.drawable.ferret_png, "ferret"
                , "A ferret is a small, furry creature with a cone-shaped nose, long tail and a long, pear-shaped body with short legs and long claws. Ferrets are related to wolverines, ermines, minks and weasels in the Mustela genus. They are popular, though often controversial, pets."
                , "ferret.sfb"));
        assets.add(new Asset(R.drawable.greategret_png, "greategret"
                , "The great egret (Ardea alba), also known as the common egret, large egret, or (in the Old World) great white egret[2] or great white heron[3][4][5] is a large, widely distributed egret, with four subspecies found in Asia, Africa, the Americas, and southern Europe. Distributed across most of the tropical and warmer temperate regions of the world, it builds tree nests in colonies close to water."
                , "greategret.sfb"));
        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Asset word = assets.get(position);
                Intent intentUri = new Intent(BiologyActivity.this,FragmentAr.class);
                intentUri.putExtra("URI",word.getmAssetUri());
                startActivity(intentUri);
            }
        });
    }
}
