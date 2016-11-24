package com.skype.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class Answer {
    @Id
    private int id;
    private String content;
    @DBRef
    private User author;
    private int grade;
}
