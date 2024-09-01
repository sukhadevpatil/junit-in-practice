package com.appsdeveloperblog.estore.repository;

import com.appsdeveloperblog.estore.model.User;

public interface UserRepository {
    boolean save(User user);
}
