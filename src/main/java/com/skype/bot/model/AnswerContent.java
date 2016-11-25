package com.skype.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by surmab on 25.11.2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames=true)
@Entity
public class AnswerContent implements com.skype.bot.api.AnswerContentModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Enumerated
    private ContentType type;
    private String text;
    public enum ContentType{
        TEXT,
        TXT,
        PDF,
        GIF,
        IMG
    }
}
