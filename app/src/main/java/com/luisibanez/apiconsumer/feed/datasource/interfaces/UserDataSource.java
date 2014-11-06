package com.luisibanez.apiconsumer.feed.datasource.interfaces;

import com.luisibanez.apiconsumer.feed.datasource.interfaces.callbacks.GetUserCallback;

/**
 * this data source provide users
 */
public interface UserDataSource {
    void getUsers(GetUserCallback callback);
}
