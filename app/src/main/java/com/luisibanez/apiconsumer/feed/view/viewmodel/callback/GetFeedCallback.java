package com.luisibanez.apiconsumer.feed.view.viewmodel.callback;

import com.luisibanez.apiconsumer.feed.domain.boundaries.FeedBoundary;

public interface GetFeedCallback {
    void feedReady(FeedBoundary feedBoundary);
}
