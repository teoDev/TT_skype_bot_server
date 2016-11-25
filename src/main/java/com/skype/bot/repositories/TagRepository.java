package com.skype.bot.repositories;

import com.skype.bot.model.Category;
import com.skype.bot.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface TagRepository extends JpaRepository<Tag, String> {
    Tag findByName(String name);
    List<Tag> findByCategory(Category category);
}
