package com.skype.bot.api;

/**
 * Created by surmab on 25.11.2016.
 */
public interface TagModel {
    String getName();

    com.skype.bot.model.Category getCategory();

    void setName(String name);

    void setCategory(com.skype.bot.model.Category category);
}
