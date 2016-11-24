package com.skype.bot.config;

import com.skype.bot.model.*;
import com.skype.bot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    List<Answer> answers;
    List<Tag> tags;
    Random generator = new Random();

    @Override
    public void run(String... strings) throws Exception {
        users = createUsers();

        createCategories();
        answers = createAnswers();
        createQuestions();
        tags = createTags();
        questionRepository.deleteAll();
        userRepository.deleteAll();
        answerRepository.deleteAll();
        tagRepository.deleteAll();
        categoryRepository.deleteAll();

        // save a couple of customers
        userRepository.save(users);
        answerRepository.save(answers);
        questionRepository.save(questions);
        categoryRepository.save(categories);
        tagRepository.save(tags);

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Question question : questionRepository.findAll()) {
            System.out.println(question);
        }
        System.out.println();
    }

    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, randomString(10), randomString(10));
            users.add(user);
        }
        return users;
    }

    public void createQuestions() {
        for (int i = 0; i < 10; i++) {
            Question question = new Question(i, randomString(20), answers, createTags());
            questions.add(question);
        }
    }

    public List<Answer> createAnswers() {
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Answer answer = new Answer(i, randomString(10), users.get(i), generator.nextInt(10));
            answers.add(answer);
        }
        return answers;
    }

    public List<Tag> createTags() {
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Tag tag = new Tag(i, randomString(5), categories.get(generator.nextInt(10)));
            tags.add(tag);
        }
        return tags;
    }
    public void createCategories() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category(i, randomString(5));
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
