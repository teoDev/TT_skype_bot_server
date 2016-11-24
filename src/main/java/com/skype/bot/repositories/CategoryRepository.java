package com.skype.bot.repositories;

import com.skype.bot.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends MongoRepository<Category, String> {
}
