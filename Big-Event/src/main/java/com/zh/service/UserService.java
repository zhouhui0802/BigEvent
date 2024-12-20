package com.zh.service;

import com.zh.pojo.User;

public interface UserService {

    User findByUserName(String username);

    void registerUser(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);
}
