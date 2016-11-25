package com.skype.bot.repositories;

import com.skype.bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by surmab on 24.11.2016.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(Integer id);
    List<User> findByUsername(String name);
    List<User> findByUsernameOrPassword(String name, String password);
}
