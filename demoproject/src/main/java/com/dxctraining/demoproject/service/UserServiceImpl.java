package com.dxctraining.demoproject.service;

import com.dxctraining.demoproject.dao.IUserDao;
import com.dxctraining.demoproject.entities.User;
import com.dxctraining.demoproject.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public User saveUser(User user) {
        validate(user);
        user = dao.save(user);
        return user;
    }

    private void validate(User user) {
        if(user==null){
            throw new UserNotFoundException("user should not be null");
        }
    }

    @Override
    public User findUserById(Integer userId) {
        Optional<User>optional=dao.findById(userId);
        if(!optional.isPresent()){
            throw new UserNotFoundException("Invalid userId, enter a valid userId");
        }
        User user = optional.get();
        return user;
    }

    @Override
    public List<User> allUsers() {
        List<User>list= dao.findAll();
        return list;
    }

    @Override
    public User updateUser(User user) {
        validate(user);
        User newUser = findUserById(user.getUserId());
        newUser.setName(user.getName());
        newUser.setDescription(user.getDescription());
        newUser.setStartDate(user.getStartDate());
        newUser.setEndDate(user.getEndDate());
        newUser.setStatus(user.getStatus());
        newUser=dao.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(Integer userId) {
        findUserById(userId);
        dao.deleteById(userId);
    }
}
