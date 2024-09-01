package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.exception.UserServiceException;
import com.appsdeveloperblog.estore.model.User;
import com.appsdeveloperblog.estore.repository.UserRepository;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String firstName,
                           String lastName,
                           String email,
                           String password,
                           String repeatPassword) {

        if(firstName == null || firstName.trim().length() == 0) {
            throw new IllegalArgumentException("User's first name is empty");
        }

        if(lastName == null || lastName.trim().length() == 0) {
            throw new IllegalArgumentException("User's last name is empty");
        }

        User user = new User(firstName, lastName, email, UUID.randomUUID().toString());

        boolean isUserCreated = userRepository.save(user);
        if(!isUserCreated) {
            throw new UserServiceException("Could not create user");
        }

        return user;

    }
}
