package com.skype.bot.repositories;
import com.skype.bot.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "question", path = "question")
public interface QuestionRepository extends MongoRepository<Question, String> {
        public Question findById(@Param("id") int id);
        public Question findByQuestion(@Param("question") String question);
}
