package com.example.mongodb.service.Impl;


import com.example.mongodb.entities.User;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.repository.dao.Impl.RepositoryCriteriaImpl;
import com.example.mongodb.repository.dao.RepositoryPersonalized;
import com.example.mongodb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    RepositoryPersonalized repositoryPersonalized;

    UserRepository userRepository;


    public UserServiceImpl(RepositoryCriteriaImpl repositoryPersonalized,
                           UserRepository userRepository) {
        this.repositoryPersonalized = repositoryPersonalized;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        System.out.println("service");
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public User update(User userdto) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
