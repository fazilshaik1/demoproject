package com.dxctraining.demoproject.dao;

import com.dxctraining.demoproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {

}
