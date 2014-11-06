package com.luisibanez.apiconsumer.feed.view.provider;

import com.luisibanez.apiconsumer.feed.view.viewmodel.FeedViewModel;

public class FeedProvider {

    FeedViewModel viewModel;

    public FeedProvider(FeedViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public FeedViewModel getFeed() {
        return viewModel;
    }

}
