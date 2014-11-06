package com.luisibanez.apiconsumer.feed.view.viewmodel;

import com.luisibanez.apiconsumer.feed.domain.boundaries.FeedBoundary;
import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.domain.interactors.GetFeed;
import com.luisibanez.apiconsumer.feed.view.ui.callback.RefreshFeedCallback;
import com.luisibanez.apiconsumer.feed.view.viewmodel.callback.GetFeedCallback;
import com.luisibanez.apiconsumer.feed.view.viewmodel.mapper.UserViewMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A list of view information of users
 */
public class FeedViewModel {

    UserViewMapper userViewMapper;
    GetFeed getFeed;

    private List<UserViewModel> users = new ArrayList<UserViewModel>();
    private RefreshFeedCallback refreshFeedCallback;

    public FeedViewModel(GetFeed getFeed, UserViewMapper mapper) {
        this.getFeed = getFeed;
        this.userViewMapper = mapper;
    }

    public void addUser(UserViewModel user) {
       users.add(user);
    }

    public List<UserViewModel> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public void populateFeed(RefreshFeedCallback populateFeedCallback) {
        this.refreshFeedCallback = populateFeedCallback;
        getFeed.getFeed(getFeedCallback);
    }


    GetFeedCallback getFeedCallback = new GetFeedCallback() {
        @Override
        public void feedReady(FeedBoundary feedBoundary) {
            users.clear();

            for (UserBoundary userBoundary : feedBoundary.getUsers()) {

                UserViewModel userViewModel = userViewMapper.mapper(userBoundary);
                users.add(userViewModel);
            }

            refreshFeedCallback.refreshPopulated();
        }
    };
}

