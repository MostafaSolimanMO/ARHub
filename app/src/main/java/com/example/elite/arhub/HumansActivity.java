package com.example.elite.arhub;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HumansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);

        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.brain_png, "Brain"
                , "The brain is one of the largest and most complex organs in the human body.\n" +
                "It is made up of more than 100 billion nerves that communicate in trillions of connections called synapses",
                "brain.sfb"));
        assets.add(new Asset(R.drawable.heart_png, "Heart"
                ,"The heart is a muscular organ in most animals, which pumps blood through the blood vessels of the circulatory system. Blood provides the body with oxygen and nutrients, as well as assisting in the removal of metabolic wastes. In humans, the heart is located between the lungs, in the middle compartment of the chest." ,"heart.sfb"));
        assets.add(new Asset(R.drawable.skel, "Skeleton"
                , "A skeleton is the hard structure that protects the internal organs of a living thing. Skeletons can be inside the body or outside the body.",
                "skel.sfb"));


        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Asset word = assets.get(position);
                Intent intentUri = new Intent(HumansActivity.this,FragmentAr.class);
                intentUri.putExtra("URI",word.getmAssetUri());
                startActivity(intentUri);
            }
        });
    }
}

