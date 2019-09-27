package com.example.elite.arhub;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SpaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);

        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.astronaut_png, "Astronaut"
                , "An astronaut or cosmonaut is a person trained by a human spaceflight program to command, pilot, or serve as a crew member of a spacecraft."
                , "astronaut.sfb"));
        assets.add(new Asset(R.drawable.satellite_png, "Satellite"
                , "A satellite is a moon, planet or machine that orbits a planet or star. For example, Earth is a satellite because it orbits the sun."
                , "satellite.sfb"));
        assets.add(new Asset(R.drawable.spaceshuttle_png, "Space Shuttle"
                , "The Space Shuttle was a partially reusable low Earth orbital spacecraft system that was operated from 1981 to 2011 by the U.S. National Aeronautics and Space Administration (NASA) as part of the Space Shuttle program."
                , "spaceShuttle.sfb"));


        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
    }
}
