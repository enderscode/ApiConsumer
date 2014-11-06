package com.luisibanez.apiconsumer.feed.domain.interactors;

import com.luisibanez.apiconsumer.feed.view.viewmodel.callback.GetFeedCallback;

/**
 * This interface define the contract for obtain the feed.
 */
public interface GetFeed {
    void getFeed(GetFeedCallback getFeedCallback);
}
