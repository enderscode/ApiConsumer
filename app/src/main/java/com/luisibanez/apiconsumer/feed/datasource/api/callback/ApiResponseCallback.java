package com.luisibanez.apiconsumer.feed.datasource.api.callback;

/**
 *
 */
public interface ApiResponseCallback<T> {
    void complete(T response);
}
