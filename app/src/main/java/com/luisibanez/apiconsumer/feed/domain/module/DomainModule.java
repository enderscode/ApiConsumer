package com.luisibanez.apiconsumer.feed.domain.module;

import com.luisibanez.apiconsumer.feed.domain.interactors.GetFeed;
import com.luisibanez.apiconsumer.feed.domain.mappers.UserMapper;
import com.luisibanez.apiconsumer.feed.domain.mappers.UserMapperManual;

import dagger.Module;
import dagger.Provides;

@Module(complete = false,
        library = true)
public class DomainModule {

    @Provides
    GetFeed provideFeed(GetFeedImpl feedImp) {
        return feedImp;
    }

    @Provides
    UserMapper provideUserMapperManual(UserMapperManual userMapperAuto) {
        return userMapperAuto;
    }

}
