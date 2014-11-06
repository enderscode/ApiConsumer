package com.luisibanez.apiconsumer.feed.datasource.module;

import android.util.Log;

import com.luisibanez.apiconsumer.feed.datasource.api.Api;
import com.luisibanez.apiconsumer.feed.datasource.api.call.rest.GetFeedCall;
import com.luisibanez.apiconsumer.feed.datasource.api.callback.ApiResponseCallback;
import com.luisibanez.apiconsumer.feed.datasource.api.model.UserApi;
import com.luisibanez.apiconsumer.feed.datasource.api.model.UserApiEntry;
import com.luisibanez.apiconsumer.feed.datasource.interfaces.UserDataSource;
import com.luisibanez.apiconsumer.feed.datasource.interfaces.callbacks.GetUserCallback;
import com.luisibanez.apiconsumer.feed.domain.gateway.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * implementation for UserDataSource
 */
class UserDataSourceImp implements UserDataSource, ApiResponseCallback<List<UserApiEntry>> {


    @Inject
    @Named("ApiRest")
    Api api;

    private Collection<GetUserCallback> getUserCallbacks =
            Collections.synchronizedCollection(new ArrayList<GetUserCallback>());

    UserDataSourceImp(Api api) {
        this.api = api;
    }

    @Override
    public void getUsers(GetUserCallback callback) {
        getUserCallbacks.add(callback);
        api.call(new GetFeedCall(this));
    }

    @Override
    public void complete(List<UserApiEntry> response) {
        List<User> users = new ArrayList<User>();

        for (UserApiEntry userApiEntry : response) {
            UserApi user = userApiEntry.getUser();

            Log.d("added",user.getEmail());
            //for this test we use the email as id
            User newUser = new User(user.getEmail());
            newUser.setName(user.getName().getFirst());
            newUser.setSurname(user.getName().getLast());
            newUser.setAvatar(user.getPicture().getThumbnail());

            users.add(newUser);
        }

        synchronized (getUserCallbacks){
            for (GetUserCallback getUserCallback : getUserCallbacks) {
                getUserCallback.usersReady(users);
            }

            getUserCallbacks.clear();
        }
    }
}
