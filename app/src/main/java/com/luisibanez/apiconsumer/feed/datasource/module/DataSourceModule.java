package com.luisibanez.apiconsumer.feed.datasource.module;

import com.luisibanez.apiconsumer.feed.datasource.api.Api;
import com.luisibanez.apiconsumer.feed.datasource.interfaces.UserDataSource;
import com.luisibanez.apiconsumer.feed.datasource.module.api.ApiRest;
import com.luisibanez.apiconsumer.globalutils.cache.Cache;
import com.luisibanez.apiconsumer.globalutils.cache.implementations.MapKeysCache;
import com.luisibanez.apiconsumer.globalutils.module.AndroidModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(library = true,
        includes = AndroidModule.class)
public class DataSourceModule {

    public DataSourceModule() {

    }

    @Provides
    @Singleton
    @Named("ApiRest")
    Api provideApiRest(ApiRest apiRest) {
        return apiRest;
    }


    @Provides
    @Singleton
    @Named("MapKeysCache")
    Cache provideApiParse() {
        return new MapKeysCache();
    }

    @Provides
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setServer(ApiRest.DOMAIN)
                .build();
    }

    @Provides
    UserDataSource provideUserDataSource(@Named("ApiRest") Api api) {
        return new UserDataSourceImp(api);
    }

}
