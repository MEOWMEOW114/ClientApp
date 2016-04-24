package com.easydeliver.clientapp;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.bumptech.glide.request.target.ViewTarget;
import com.helpshift.Core;
import com.helpshift.support.Support;

import java.util.HashMap;

/**
 * Created by tomlee on 30/11/15.
 */
public class App extends MultiDexApplication {

    @Override
    public void onCreate() { // or in GlideModule.applyOptions
        super.onCreate();
        ViewTarget.setTagId(R.id.glide_request);
//        FacebookSdk.sdkInitialize(getApplicationContext());
        HashMap config = new HashMap();

        Core.init(Support.getInstance());

        Core.install(this,
                "34a4e1d11c2602b5ff459dec2ea89cbd",
                "feedme.helpshift.com",
                "feedme_platform_20160316050344878-ad3266a8cf3050f", config);

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }
}

