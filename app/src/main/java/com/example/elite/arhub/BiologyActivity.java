package com.example.elite.arhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
    }
}
