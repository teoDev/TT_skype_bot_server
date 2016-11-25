package com.skype.bot.api;

/**
 * Created by surmab on 25.11.2016.
 */
public interface UserModel {
    int getId();

    String getUsername();

    String getPassword();

    void setId(int id);

    void setUsername(String username);

    void setPassword(String password);
}
