package com.luisibanez.apiconsumer.feed.domain.module;

import com.luisibanez.apiconsumer.feed.datasource.interfaces.UserDataSource;
import com.luisibanez.apiconsumer.feed.datasource.interfaces.callbacks.GetUserCallback;
import com.luisibanez.apiconsumer.feed.domain.boundaries.FeedBoundary;
import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.domain.gateway.User;
import com.luisibanez.apiconsumer.feed.domain.interactors.GetFeed;
import com.luisibanez.apiconsumer.feed.domain.mappers.UserMapper;
import com.luisibanez.apiconsumer.feed.view.viewmodel.callback.GetFeedCallback;

import java.util.List;

import javax.inject.Inject;

/**
 * this is an implementation for feed
 */
class GetFeedImpl implements GetFeed {


    private final UserMapper userMapper;
    UserDataSource userDataSource;

    public List<User> users;
    private GetFeedCallback getFeedCallback;

    @Inject
    GetFeedImpl(UserDataSource userDataSource,UserMapper userMapper) {
        this.userDataSource = userDataSource;
        this.userMapper = userMapper;
    }

    @Override
    public void getFeed(GetFeedCallback getFeedCallback) {

        this.getFeedCallback = getFeedCallback;
        userDataSource.getUsers(getUserCallback);

    }

    GetUserCallback getUserCallback = new GetUserCallback() {

        @Override
        public void usersReady(List<User> users) {
            GetFeedImpl.this.users = users;

            FeedBoundary feedBoundary = new FeedBoundary();
            for (User user : users) {
                UserBoundary userBoundary = userMapper.mapper(user);
                feedBoundary.add(userBoundary);
            }

            getFeedCallback.feedReady(feedBoundary);
        }
    };

}
