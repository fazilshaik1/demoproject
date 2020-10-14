package com.dxctraining.demoproject.controller;

import com.dxctraining.demoproject.dto.CreateUserRequest;
import com.dxctraining.demoproject.dto.UpdateUser;
import com.dxctraining.demoproject.dto.UserDto;
import com.dxctraining.demoproject.entities.User;
import com.dxctraining.demoproject.service.IUserService;
import com.dxctraining.demoproject.util.DateUtil;
import com.dxctraining.demoproject.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private IUserService service;

    @Autowired
    private UserUtil util;

    @Autowired
    private DateUtil dateUtil;

    @PostMapping("/add")
    public UserDto addUser(@RequestBody CreateUserRequest request){
        String name = request.getName();
        String description = request.getDescription();
        long startDateMillis = request.getStartDate();
        long endDateMillis = request.getEndDate();
        String status = request.getStatus();
        LocalDateTime startDate = dateUtil.toDateTime(startDateMillis);
        LocalDateTime endDate = dateUtil.toDateTime(endDateMillis);
        User user = new User(name,description,startDate,endDate,status);
        user = service.saveUser(user);
        UserDto response = util.userDto(user);
        return response;
    }

    @GetMapping("/get/{userId}")
    public UserDto findUserById(@PathVariable("userId")Integer userId){
        User user = service.findUserById(userId);
        UserDto response = util.userDto(user);
        return response;
    }

    @GetMapping("/get/all")
    public List<UserDto> allUsers(){
        List<User> list = service.allUsers();
        List<UserDto> response = new ArrayList<>();
        for(User user:list){
            UserDto dto = util.userDto(user);
            response.add(dto);
        }
        return response;
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UpdateUser req){
        long startDateMillis = req.getStartDate();
        LocalDateTime startDate = dateUtil.toDateTime(startDateMillis);
        long endDateMillis = req.getEndDate();
        LocalDateTime endDate = dateUtil.toDateTime(endDateMillis);
        User user = new User();
        user.setUserId(req.getUserId());
        user.setName(req.getName());
        user.setDescription(req.getDescription());
        user.setStartDate(startDate);
        user.setEndDate(endDate);
        user.setStatus(user.getStatus());
        user = service.updateUser(user);
        UserDto response = util.userDto(user);
        return response;
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable("userId")Integer userId){
        service.deleteUser(userId);
        return true;
    }
}
