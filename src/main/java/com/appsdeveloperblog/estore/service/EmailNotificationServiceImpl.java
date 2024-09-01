package com.appsdeveloperblog.estore.service;

import com.appsdeveloperblog.estore.model.User;

public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void scheduleEmailNotification(User user) {
        System.out.println("scheduleEmailNotification...");
    }
}
