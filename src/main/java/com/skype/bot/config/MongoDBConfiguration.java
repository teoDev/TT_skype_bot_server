package com.skype.bot.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

/**
 * Created by surmab on 24.11.2016.
 */
@Configuration
@EnableMongoRepositories({"com.skype.bot.repositories","com.skype.bot.model"})
public class MongoDBConfiguration extends AbstractMongoConfiguration {
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;
    @Value("${spring.data.mongodb.port}")
    private String mongoPort;
    @Value("${spring.data.mongodb.username}")
    private String user;
    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return super.mongoMappingContext();
    }
    @Override
    @Bean
    public Mongo mongo() throws Exception {
        MongoCredential mongodb = MongoCredential.createCredential(user, mongoDB, password.toCharArray());
        return new MongoClient(singletonList(new ServerAddress(mongoHost, 27017)),
                singletonList(mongodb));
    }

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return mongoDB;
    }
}