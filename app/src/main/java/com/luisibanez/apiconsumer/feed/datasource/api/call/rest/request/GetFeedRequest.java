package com.luisibanez.apiconsumer.feed.datasource.api.call.rest.request;

import com.luisibanez.apiconsumer.feed.datasource.api.call.rest.response.GetFeedResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.Callback;

/**
 * The request for the feed
 */
public interface GetFeedRequest {

    @GET("/")
    void getRandomUsers(@Query("results") int maxUsers,
                        Callback<GetFeedResponse> callback);

}
