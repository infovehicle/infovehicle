package com.info.vehicle;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;

public class InfoVehicle extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the Audience Network SDK
        AudienceNetworkAds.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
