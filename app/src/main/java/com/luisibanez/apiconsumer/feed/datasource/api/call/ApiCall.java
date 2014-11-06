package com.luisibanez.apiconsumer.feed.datasource.api.call;

import com.luisibanez.apiconsumer.feed.datasource.api.callback.ApiResponseCallback;

/**
 * Basic Api call to the Api System.
 */
public abstract class ApiCall {

    protected ApiResponseCallback responseCallback;

    public ApiCall(ApiResponseCallback responseCallback) {
        this.responseCallback = responseCallback;
    }

    public abstract void call();
}
