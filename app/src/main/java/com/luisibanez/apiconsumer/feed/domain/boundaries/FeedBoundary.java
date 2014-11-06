package com.luisibanez.apiconsumer.feed.domain.boundaries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FeedBoundary {
    private boolean success = false;
    List<UserBoundary> users = new ArrayList<UserBoundary>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<UserBoundary> getUsers() {
        return users;
    }

    public void add(UserBoundary user) {
        users.add(user);
    }
}
