package com.example.elite.arhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class GeologyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_list);

        final ArrayList<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(R.drawable.cliff_png, "cliff"
                , "In geography and geology, a cliff is a vertical, or nearly vertical, rock exposure. Cliffs are formed as erosion landforms by the processes of weathering and erosion. Cliffs are common on coasts, in mountainous areas, escarpments and along rivers. Cliffs are usually formed by rock that is resistant to weathering and erosion. Sedimentary rocks most likely to form cliffs include sandstone, limestone, chalk, and dolomite. Igneous rocks such as granite and basalt also often form cliffs. "
                , "cliff.sfb"));
        assets.add(new Asset(R.drawable.boulder_png, "boulder"
                , "In geology, a boulder is a rock fragment with size greater than 25.6 centimetres (10.1 in) in diameter.[1] Smaller pieces are called cobbles and pebbles. While a boulder may be small enough to move or roll manually, others are extremely massive.[2] In common usage, a boulder is too large for a person to move. Smaller boulders are usually just called rocks or stones. The word boulder is short for boulder stone, from Middle English bulderston or Swedish bullersten."
                , "boulder.sfb"));
        assets.add(new Asset(R.drawable.nature_png, "nature"
                , "Nature, in the broadest sense, is the natural, physical, or material world or universe. \"Nature\" can refer to the phenomena of the physical world, and also to life in general. The study of nature is a large, if not the only, part of science. Although humans are part of nature, human activity is often understood as a separate category from other natural phenomena."
                , "nature.sfb"));
        assets.add(new Asset(R.drawable.pond_png, "pond"
                , "A pond is an area filled with water, either natural or artificial, that is smaller than a lake.[1] It may arise naturally in floodplains as part of a river system, or be a somewhat isolated depression (such as a kettle, vernal pool, or prairie pothole). It may contain shallow water with marsh and aquatic plants and animals."
                , "pond.sfb"));
        assets.add(new Asset(R.drawable.volcano_png, "volcano"
                , "A volcano is a rupture in the crust of a planetary-mass object, such as Earth, that allows hot lava, volcanic ash, and gases to escape from a magma chamber below the surface."
                , "volcano.sfb"));
        AssetAdapter adapter = new AssetAdapter(this, assets);
        ListView listView = findViewById(R.id.asset_list);
        listView.setAdapter(adapter);
    }
}
