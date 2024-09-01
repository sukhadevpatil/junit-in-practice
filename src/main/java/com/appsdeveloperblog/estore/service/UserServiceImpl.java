package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.exception.UserServiceException;
import com.appsdeveloperblog.estore.model.User;
import com.appsdeveloperblog.estore.repository.UserRepository;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    EmailNotificationService emailNotificationService;

    public UserServiceImpl(UserRepository userRepository, EmailNotificationService emailNotificationService) {
        this.userRepository = userRepository;
        this.emailNotificationService = emailNotificationService;
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

        boolean isUserCreated;
        try {
            isUserCreated = userRepository.save(user);
        } catch (RuntimeException exc) {
            throw new UserServiceException("Could not create user");
        }
        if(!isUserCreated) {
            throw new UserServiceException("Could not create user");
        }

        try {
            emailNotificationService.scheduleEmailNotification(user);
        } catch (RuntimeException exception) {
            throw new UserServiceException(exception.getMessage());
        }

        return user;

    }
}
