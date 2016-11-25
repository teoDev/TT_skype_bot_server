package com.skype.bot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames=true)
@Entity
public class User implements com.skype.bot.api.UserModel,Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
