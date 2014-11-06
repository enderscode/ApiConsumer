package com.luisibanez.apiconsumer.feed.datasource.interfaces.callbacks;

import com.luisibanez.apiconsumer.feed.domain.gateway.User;

import java.util.List;

/**
 * This is the callback with all users that has been requested.
 */
public interface GetUserCallback {
    public void usersReady(List<User> users);
}
