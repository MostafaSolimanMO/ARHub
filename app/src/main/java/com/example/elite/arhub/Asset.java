package com.example.elite.arhub;

import android.net.Uri;

class Asset {
     private int mAssetImageId;
     private String mAssetTitle;
     private String mAssetDetails;
     private String mAssetUri;

     public Asset(int AssetImageId, String AssetTitle, String AssetDetails, String AssetUri){
         mAssetImageId = AssetImageId;
         mAssetTitle = AssetTitle;
         mAssetDetails = AssetDetails;
         mAssetUri = AssetUri;
     }

    public int getmAssetImageId() {
        return mAssetImageId;
    }

    public String getmAssetTitle() {
        return mAssetTitle;
    }

    public String getmAssetDetails() {
        return mAssetDetails;
    }

    public String getmAssetUri() {
        return mAssetUri;
    }
}
