package com.skype.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * Created by surmab on 24.11.2016.
 */
@Data
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class Tag {
    @Id
    private int id;
    private String name;
    private Category category;
}
