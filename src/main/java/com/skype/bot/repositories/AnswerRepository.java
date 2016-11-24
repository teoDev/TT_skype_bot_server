package com.skype.bot.repositories;

import com.skype.bot.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "answer", path = "answer")
public interface AnswerRepository extends MongoRepository<Answer, String> {
}
