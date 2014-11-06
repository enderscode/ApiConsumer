package com.luisibanez.apiconsumer.feed.datasource.api.call.rest;

import com.luisibanez.apiconsumer.feed.datasource.api.call.rest.request.GetFeedRequest;
import com.luisibanez.apiconsumer.feed.datasource.api.call.rest.response.GetFeedResponse;
import com.luisibanez.apiconsumer.feed.datasource.api.callback.ApiResponseCallback;
import com.luisibanez.apiconsumer.feed.datasource.api.model.UserApiEntry;
import com.luisibanez.apiconsumer.globalutils.module.LoggerProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Api Call to request
 */
public class GetFeedCall extends ApiRestCall implements Callback<GetFeedResponse> {
    private static final int MAX_USERS = 10;
    private static final String LOGTAG = "GetFeedCall";
    private List<UserApiEntry> responseBuffer = new ArrayList<UserApiEntry>();
    private GetFeedRequest request;

    public GetFeedCall(ApiResponseCallback<List<UserApiEntry>> apiResponseCallback) {
        super(apiResponseCallback);
    }

    @Override
    public void call(RestAdapter restAdapter) {
        responseBuffer.clear();

        request = restAdapter.create(GetFeedRequest.class);
        request.getRandomUsers(MAX_USERS, this);
    }

    @Override
    public void success(GetFeedResponse apiUsers, Response response) {
        responseBuffer.addAll(apiUsers.getResults());
        if (responseBuffer.size() >= MAX_USERS) {
            super.responseCallback.complete(responseBuffer);
        } else {
            request.getRandomUsers(MAX_USERS, this);
        }
    }

    @Override
    public void failure(RetrofitError retrofitError) {
        LoggerProvider.getLogger().d(LOGTAG, "an error happened " + retrofitError.getBody());
    }
}
