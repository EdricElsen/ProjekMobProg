package com.example.tri_games;

import android.app.Application;

import com.huawei.hms.ads.HwAds;

public class AdActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this);
    }
}
