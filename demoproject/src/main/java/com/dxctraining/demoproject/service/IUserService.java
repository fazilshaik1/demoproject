package com.dxctraining.demoproject.service;

import com.dxctraining.demoproject.entities.User;
import java.util.List;

public interface IUserService {

    User saveUser(User user);

    User findUserById(Integer userId);

    List<User> allUsers();

    User updateUser(User user);

    void deleteUser(Integer userId);
}
