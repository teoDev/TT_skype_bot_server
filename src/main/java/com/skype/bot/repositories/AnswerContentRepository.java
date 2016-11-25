package com.skype.bot.repositories;

import com.skype.bot.model.Answer;
import com.skype.bot.model.AnswerContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by surmab on 25.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "answer-content", path = "answer-content")
public interface AnswerContentRepository extends JpaRepository<AnswerContent, Integer> {
}
