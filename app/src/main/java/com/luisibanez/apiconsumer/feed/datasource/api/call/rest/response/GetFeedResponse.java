package com.luisibanez.apiconsumer.feed.datasource.api.call.rest.response;

import com.luisibanez.apiconsumer.feed.datasource.api.model.UserApiEntry;

import java.util.List;

/**
 * the Api response for feed call
 */
public class GetFeedResponse {
    private List<UserApiEntry> results;

    public List<UserApiEntry> getResults() {
        return results;
    }
}
