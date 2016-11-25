package com.skype.bot.repositories;

import com.skype.bot.model.Answer;
import com.skype.bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "answers", path = "answers")
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    AnswerRepository findAnswerById(int id);
    List<AnswerRepository> findAnswerByGrade(int grade);
    List<AnswerRepository> findAnswerByAuthor(User Author);
    List<AnswerRepository> findAnswerByAuthorAndGradeGreaterThan(User Author,int grade);

}
