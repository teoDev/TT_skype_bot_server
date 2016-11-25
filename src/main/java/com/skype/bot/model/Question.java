package com.skype.bot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames=true)
@Entity
public class Question implements com.skype.bot.api.QuestionModel, Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String question;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "question_answers", joinColumns =
            @JoinColumn(name = "QUESTION_ID") ,
            inverseJoinColumns = { @JoinColumn(name = "ANSWER_ID") })
    private Set<Answer> answers;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "question_tags", joinColumns =
            @JoinColumn(name = "QUESTION_ID"),
            inverseJoinColumns = { @JoinColumn(name = "TAG_ID") })
    private Set<Tag> tags;
    @JsonCreator
    public Question(@JsonProperty int id){
        this.id = id;
    }
}
