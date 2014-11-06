package com.luisibanez.apiconsumer.feed.view.module;


import android.content.Context;

import com.luisibanez.apiconsumer.daggerUtils.ForApplication;
import com.luisibanez.apiconsumer.feed.domain.interactors.GetFeed;
import com.luisibanez.apiconsumer.feed.view.provider.FeedProvider;
import com.luisibanez.apiconsumer.feed.view.ui.ApiConsumerActivity;
import com.luisibanez.apiconsumer.feed.view.ui.UserListFragment;
import com.luisibanez.apiconsumer.feed.view.viewmodel.FeedViewModel;
import com.luisibanez.apiconsumer.feed.view.viewmodel.mapper.UserViewMapper;
import com.luisibanez.apiconsumer.feed.view.viewmodel.mapper.UserViewMapperManual;
import com.luisibanez.apiconsumer.uibase.transformation.TransformationBuilder;
import com.luisibanez.apiconsumer.uibase.transformation.privates.TransformationBuilderPicasso;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(injects = {ApiConsumerActivity.class, UserListFragment.class},
        complete = false,
        library = true)
public class FeedViewModule {

    @Provides
    FeedProvider provideFeedProvider(FeedViewModel viewModel) {
        return new FeedProvider(viewModel);
    }

    @Provides
    FeedViewModel provideFeedViewModel(GetFeed getFeed, UserViewMapper mapper) {
        return new FeedViewModel(getFeed, mapper);
    }

    @Provides
    @Singleton
    Picasso providePicasso(@ForApplication Context context) {
        return Picasso.with(context);
    }

    @Provides
    TransformationBuilder provideTransformationBuilder(TransformationBuilderPicasso
                                                               transformationBuilderPicasso) {
        return transformationBuilderPicasso;
    }

    @Provides
    UserViewMapper provideUserViewMapperManual(UserViewMapperManual userViewMapperManual) {
        return userViewMapperManual;
    }
}
