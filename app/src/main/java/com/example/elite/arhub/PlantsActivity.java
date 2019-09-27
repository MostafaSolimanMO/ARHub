package com.example.elite.arhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);

        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.eflower_png, "Carnivorous flower"
                , "Carnivorous plants are plants that derive some or most of their nutrients (but not energy) from trapping and consuming animals or protozoans, typically insects and other arthropods. Carnivorous plants have adapted to grow in places where the soil is thin or poor in nutrients, especially nitrogen, such as acidic bogs. Charles Darwin wrote Insectivorous Plants, the first well-known treatise on carnivorous plants, in 1875."
                , "eflower.sfb"));
        assets.add(new Asset(R.drawable.oaktree_png, "Oak tree"
                , "Oak is the common name for many acorn-producing trees and shrubs that are members of the beech, or Fagaceae, family. Oak trees are classified as members of the genus Quercus, a Latin word said to be derived from a Celtic word meaning \"fine tree.\" Worldwide there are more than 600 different species of oak. They thrive across the Northern Hemisphere in China, Japan, Europe, the British Isles, and in all of the continental United States except for Alaska. More than half of the 600 species are native to North America. Yet only about 60 varieties grow north of Mexico. In the forests of northern areas that have short summer growing seasons and long winters, such as Canada, northern Europe, and Siberia, varieties of oak are very scarce."
                , "Oaktree.sfb"));
        assets.add(new Asset(R.drawable.flower_png, "Flower"
                , "Flowers are the reproductive parts of flowering plants. A flower is a special part of the plant. Flowers are also called the bloom or blossom of a plant. Flowers have petals. Inside the part of the flower that has petals are the parts which produce pollen and seeds."
                , "Flower.sfb"));
        assets.add(new Asset(R.drawable.palm_png, "Palm"
                , "Palm trees are a botanical family of perennial lianas, shrubs, and trees. They are the only members of the family Arecaceae, which is the only family in the order Arecales. They grow in hot climates."
                , "Palm.sfb"));

        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Asset word = assets.get(position);
                Intent intentUri = new Intent(PlantsActivity.this,FragmentAr.class);
                intentUri.putExtra("URI",word.getmAssetUri());
                startActivity(intentUri);
            }
        });
    }
    }

