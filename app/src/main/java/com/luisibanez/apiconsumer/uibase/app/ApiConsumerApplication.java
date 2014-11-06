package com.luisibanez.apiconsumer.uibase.app;

import android.app.Application;

import com.luisibanez.apiconsumer.feed.datasource.module.DataSourceModule;
import com.luisibanez.apiconsumer.feed.domain.module.DomainModule;
import com.luisibanez.apiconsumer.feed.view.module.FeedViewModule;
import com.luisibanez.apiconsumer.globalutils.module.AndroidModule;
import com.luisibanez.apiconsumer.globalutils.module.GlobalModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class ApiConsumerApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
        graph.injectStatics();
    }

    protected List<Object> getModules() {
        return Arrays.asList(new AndroidModule(this), new GlobalModule(), new DomainModule(), new FeedViewModule(), new DataSourceModule());
    }



    public void inject(Object object) {
        graph.inject(object);
    }

}