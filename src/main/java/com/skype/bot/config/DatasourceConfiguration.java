package com.skype.bot.config;

import com.skype.bot.model.*;
import com.skype.bot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.*;

/**
 * Created by surmab on 24.11.2016.
 */
@Component
public class DatasourceConfiguration implements CommandLineRunner {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    List<User> users;
    List<Category> categories = new ArrayList<>();
    List<Question> questions = new ArrayList<>();
    Set<Answer> answers;
    Set<Tag> tags;
    Random generator = new Random();

    @Override
    public void run(String... strings) throws Exception {
//        users = createUsers();
//
//        createCategories();
//        tags = createTags();
//
////        categoryRepository.deleteAll();
////
//        answers = createAnswers();
//        createQuestions();
////        questionRepository.deleteAll();
////        userRepository.deleteAll();
////        answerRepository.deleteAll();
////        tagRepository.deleteAll();
//
//        // save a couple of customers
//        userRepository.save(users);
//        categoryRepository.save(categories);
//        //tagRepository.save(tags);
//        //answerRepository.save(answers);
////        questionRepository.save(questions);
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Question question : questionRepository.findAll()) {
//            System.out.println(question);
//        }
//        System.out.println();
    }

    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setPassword(randomString(10));
            user.setUsername(randomString(10));
            users.add(user);
        }
        return users;
    }

    public void createQuestions() {
        for (int i = 0; i < 10; i++) {
            Question question = new Question();
            question.setQuestion(randomString(20));
            question.setTags(createTags());
            question.setAnswers(createAnswers());
            questions.add(question);
        }
    }

    public Set<Answer> createAnswers() {
        Set<Answer> answers = new HashSet<>();
        AnswerContent answerContent = new AnswerContent();
        answerContent.setType(AnswerContent.ContentType.TXT);
        answerContent.setText("response");
        AnswerContent answerContent2 = new AnswerContent();
        answerContent2.setType(AnswerContent.ContentType.TEXT);
        answerContent2.setText("srutututu");
        AnswerContent answerContent3 = new AnswerContent();
        answerContent3.setType(AnswerContent.ContentType.GIF);
        answerContent3.setText("smieszne-obrazki-i-gify-kot-sylwester-tanczy");

        for (int i = 0; i < 10; i++) {
            Answer answer = new Answer();
            int ii = generator.nextInt(3);
            if (ii==0){
                answer.setContent(answerContent);
            }else if (ii==2){
                answer.setContent(answerContent2);
            }else{
                answer.setContent(answerContent3);
            }
            answer.setGrade(generator.nextInt(10));
            answer.setAuthor(users.get(generator.nextInt(10)));
            answers.add(answer);
        }
        return answers;
    }

    public Set<Tag> createTags() {
        Set<Tag> tags = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Tag tag = new Tag();
            tag.setName(randomString(10));
            tag.setCategory(categories.get(generator.nextInt(10)));
            tags.add(tag);
        }
        return tags;
    }
    public void createCategories() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName(randomString(10));
            categories.add(category);
        }
    }
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
