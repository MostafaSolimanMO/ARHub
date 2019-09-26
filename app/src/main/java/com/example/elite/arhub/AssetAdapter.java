package com.example.elite.arhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AssetAdapter extends ArrayAdapter<Asset> {
    public AssetAdapter(Context context, List<Asset> assets) {
        super(context, 0, assets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View AssetListItem = convertView;
        if (AssetListItem == null){
            AssetListItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.asset_item, parent, false);
        }
        Asset assetsThatWillUse = getItem(position);

        ImageView assetImage = AssetListItem.findViewById(R.id.asset_item_image);
        assetImage.setImageResource(assetsThatWillUse.getmAssetImageId());

        TextView assetTitle = AssetListItem.findViewById(R.id.asset_item_title);
        assetTitle.setText(assetsThatWillUse.getmAssetTitle());

        TextView assetDetails = AssetListItem.findViewById(R.id.asset_item_details);
        assetDetails.setText(assetsThatWillUse.getmAssetDetails());



        return AssetListItem;
    }
}
