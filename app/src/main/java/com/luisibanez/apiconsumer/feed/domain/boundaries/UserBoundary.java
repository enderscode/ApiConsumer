package com.luisibanez.apiconsumer.feed.domain.boundaries;

/**
 * this class bind information between layers
 */
public class UserBoundary {
    private String name;
    private String avatar;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
