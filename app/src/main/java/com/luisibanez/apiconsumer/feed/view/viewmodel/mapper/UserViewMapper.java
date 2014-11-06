package com.luisibanez.apiconsumer.feed.view.viewmodel.mapper;


import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.view.viewmodel.UserViewModel;

public interface UserViewMapper {
    public UserViewModel mapper(UserBoundary userBoundary);
}
