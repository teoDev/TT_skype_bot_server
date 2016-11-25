package com.skype.bot.api;

/**
 * Created by surmab on 25.11.2016.
 */
public interface AnswerModel {
    int getId();

    com.skype.bot.model.AnswerContent getContent();

    com.skype.bot.model.User getAuthor();

    int getGrade();

    void setId(int id);

    void setContent(com.skype.bot.model.AnswerContent content);

    void setAuthor(com.skype.bot.model.User author);

    void setGrade(int grade);
}
