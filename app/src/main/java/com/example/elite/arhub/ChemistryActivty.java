package com.example.elite.arhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChemistryActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);
        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.beaker_png, "Beaker"
                , "A beaker is a glass container with a flat bottom that scientists use to hold liquids. In cartoons, mad scientists sometimes cackle gleefully while pouring bubbling chemicals into beakers."
                , "Beaker.sfb"));



        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
    }
}
