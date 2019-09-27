package com.example.elite.arhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardViewChemistry = findViewById(R.id.Chemistry_cardView);
        cardViewChemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChemistryActivty.class);
                startActivity(intent);
            }
        });


        CardView cardViewHumans = findViewById(R.id.Humans_cardView);
        cardViewHumans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HumansActivity.class);
                startActivity(intent);
            }
        });


        CardView cardViewGeology = findViewById(R.id.Geology_cardView);
        cardViewGeology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GeologyActivity.class);
                startActivity(intent);
            }
        });


        CardView cardViewSpace = findViewById(R.id.Space_cardView);
        cardViewSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpaceActivity.class);
                startActivity(intent);
            }
        });


        CardView cardViewPlant = findViewById(R.id.Plants_cardView);
        cardViewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlantsActivity.class);
                startActivity(intent);
            }
        });

        CardView cardViewBiology = findViewById(R.id.Biology_cardView);
        cardViewBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BiologyActivity.class);
                startActivity(intent);
            }
        });
    }
}