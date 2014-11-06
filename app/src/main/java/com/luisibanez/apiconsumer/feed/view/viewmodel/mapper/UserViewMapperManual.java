package com.luisibanez.apiconsumer.feed.view.viewmodel.mapper;

import com.luisibanez.apiconsumer.feed.domain.boundaries.UserBoundary;
import com.luisibanez.apiconsumer.feed.view.viewmodel.UserViewModel;

import javax.inject.Inject;

public class UserViewMapperManual implements UserViewMapper {

    @Inject
    public UserViewMapperManual(){

    }

    @Override
    public UserViewModel mapper(UserBoundary userBoundary) {
        UserViewModel viewModel = new UserViewModel();

        viewModel.setName(userBoundary.getName());
        viewModel.setUrlAvatar(userBoundary.getAvatar());
        viewModel.setUserId(userBoundary.getUserId());

        return viewModel;
    }
}
