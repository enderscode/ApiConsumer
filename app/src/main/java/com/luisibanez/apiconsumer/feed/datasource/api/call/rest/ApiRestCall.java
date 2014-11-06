package com.luisibanez.apiconsumer.feed.datasource.api.call.rest;

import com.luisibanez.apiconsumer.feed.datasource.api.call.ApiCall;
import com.luisibanez.apiconsumer.feed.datasource.api.callback.ApiResponseCallback;

import retrofit.RestAdapter;

/**
 * Basic Api call to the Api System.
 */
public abstract class ApiRestCall extends ApiCall {

    private RestAdapter restAdapter;


    public ApiRestCall(ApiResponseCallback responseCallback) {
        super(responseCallback);
    }

    @Override
    public void call(){
        this.call(restAdapter);
    }

    public abstract void call(RestAdapter restAdapter);


    public void setRestAdapter(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }
}
