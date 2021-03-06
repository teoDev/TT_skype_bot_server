package com.skype.bot.model;

import com.skype.bot.api.AnswerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames=true)
@Entity
public class Answer implements AnswerModel, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private AnswerContent content;
    @OneToOne
    private User author;
    private int grade;
}
