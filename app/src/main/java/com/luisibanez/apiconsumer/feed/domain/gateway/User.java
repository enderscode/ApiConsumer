package com.luisibanez.apiconsumer.feed.domain.gateway;

/**
 * this class is a User inside bussines model
 */
public class User {

    private String userId;
    private String name;
    private String surname;
    private String avatar;

    public User(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
