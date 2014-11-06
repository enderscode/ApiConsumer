package com.luisibanez.apiconsumer.feed.domain.mappers;

import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.domain.gateway.User;

public interface UserMapper {
    public UserBoundary mapper(User user);
}
