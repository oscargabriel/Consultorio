package com.example.mongodb.repository.dao.Impl;


import com.example.mongodb.entities.User;
import com.example.mongodb.repository.dao.RepositoryPersonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCriteriaImpl implements RepositoryPersonalized {
    @Autowired
    MongoTemplate mongoTemplate;




    public RepositoryCriteriaImpl(MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Boolean existByEmail(String email) {
        return null;
    }

    @Override
    public Boolean existByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existByDocument(String document) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        User user;
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        user = mongoTemplate.find(query,User.class).get(0);
        return user;
    }

    @Override
    public List<String> findRolesByUsername(String username) {
        User user;
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        user = mongoTemplate.find(query,User.class).get(0);
        return user.getRole();
    }

    @Override
    public List<User> findAllUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public List<Long> findIdUserRoleByUserId(Long id) {
        return null;
    }

    @Override
    public User findUserById(Long id) {
        User user;

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        user = mongoTemplate.find(query,User.class).get(0);


        return user;
    }
}
