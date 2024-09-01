package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.model.User;

public interface EmailNotificationService {
    void scheduleEmailNotification(User user);
}
