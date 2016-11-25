package com.skype.bot.repositories;
import com.skype.bot.model.Answer;
import com.skype.bot.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionRepository extends JpaRepository<Question, Integer> {
         Question findById(@Param("id") int id);
         Question findByQuestion(@Param("question") String question);
         List<Question> findByAnswers(Answer answer);
         List<Question> findByTags(Answer answer);

}
