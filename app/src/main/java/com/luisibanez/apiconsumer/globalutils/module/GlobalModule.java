package com.luisibanez.apiconsumer.globalutils.module;

import com.luisibanez.apiconsumer.feed.view.ui.ApiConsumerActivity;
import com.luisibanez.apiconsumer.globalutils.interfaces.Logger;

import dagger.Module;
import dagger.Provides;

@Module(injects = {ApiConsumerActivity.class}, staticInjections = {LoggerProvider.class}, complete = false)
public class GlobalModule {

    @Provides
    Logger provideLogger() {
        return TLog.getLogger();
    }

}
