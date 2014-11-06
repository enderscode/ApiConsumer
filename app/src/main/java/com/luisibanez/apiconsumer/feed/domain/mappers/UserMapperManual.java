package com.luisibanez.apiconsumer.feed.domain.mappers;

import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.domain.gateway.User;

import javax.inject.Inject;

public class UserMapperManual implements UserMapper {
    @Inject
    public UserMapperManual() {
    }

    @Override
    public UserBoundary mapper(User user) {
        UserBoundary userBoundary = new UserBoundary();
        userBoundary.setAvatar(user.getAvatar());
        userBoundary.setUserId(user.getUserId());
        userBoundary.setName(user.getName() + " " + user.getSurname());

        return userBoundary;
    }

}
