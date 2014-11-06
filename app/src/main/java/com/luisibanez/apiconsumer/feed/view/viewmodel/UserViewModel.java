package com.luisibanez.apiconsumer.feed.view.viewmodel;

/**
 * An User View Model
 */
public class UserViewModel {
    public static final UserViewModel EMPTY = new UserViewModel();

    private String userId = "";
    private String name = "";
    private String urlAvatar = "";

    public UserViewModel() {

    }

    public String getName() {
        return name;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
