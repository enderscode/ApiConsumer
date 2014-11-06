package com.luisibanez.apiconsumer.uibase.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.luisibanez.apiconsumer.uibase.app.ApiConsumerApplication;

/**
 * This is base Activity, all activities must extends from this one.
 */
public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(this);
    }

    public void inject(Object object) {
        // Perform injection so that when this call returns all dependencies will be available for use.
        ((ApiConsumerApplication) getApplication()).inject(object);
    }

}
