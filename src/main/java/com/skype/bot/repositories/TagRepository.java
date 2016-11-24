package com.skype.bot.repositories;

import com.skype.bot.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends MongoRepository<Tag, String> {
}
