package com.skype.bot.api;

/**
 * Created by surmab on 25.11.2016.
 */
public interface AnswerContentModel {
    int getId();

    com.skype.bot.model.AnswerContent.ContentType getType();

    String getText();

    void setId(int id);

    void setType(com.skype.bot.model.AnswerContent.ContentType type);

    void setText(String text);
}
