package com.skype.bot.model;

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
public class Tag implements com.skype.bot.api.TagModel,Serializable {
    @Id
    private String name;
    @OneToOne
    private Category category;
}
