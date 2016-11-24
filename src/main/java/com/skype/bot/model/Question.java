package com.skype.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class Question {
    @Id
    private final long id;
    private String question;
    private List<Answer> answers;
    private List<Tag> tags;
}
