package com.skype.bot.api;

/**
 * Created by surmab on 25.11.2016.
 */
public interface QuestionModel {
    int getId();

    String getQuestion();

    java.util.Set<com.skype.bot.model.Answer> getAnswers();

    java.util.Set<com.skype.bot.model.Tag> getTags();

    void setId(int id);

    void setQuestion(String question);

    void setAnswers(java.util.Set<com.skype.bot.model.Answer> answers);

    void setTags(java.util.Set<com.skype.bot.model.Tag> tags);
}
