package com.appsdeveloperblog.estore.repository;

import com.appsdeveloperblog.estore.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<String, User> users = new HashMap<>();

    @Override
    public boolean save(User user) {
        boolean returnVal = false;
        if(!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            returnVal = true;
        }
        return returnVal;
    }
}
