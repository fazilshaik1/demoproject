package com.dxctraining.demoproject.util;

import com.dxctraining.demoproject.dto.UserDto;
import com.dxctraining.demoproject.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class UserUtil {

    public UserDto userDto(User user){
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setDescription(user.getDescription());
        LocalDateTime startDate = user.getStartDate();
        long startDateMillis = toMillis(startDate);
        dto.setStartDate(startDateMillis);
        LocalDateTime endDate = user.getEndDate();
        long endDateMillis = toMillis(endDate);
        dto.setEndDate(endDateMillis);
        dto.setStatus(user.getStatus());
        return dto;
    }

    long toMillis(LocalDateTime startDate){
        ZonedDateTime zonedDateTime=ZonedDateTime.of(startDate, ZoneId.systemDefault());
        long millis= zonedDateTime.toInstant().toEpochMilli();
        return millis;
    }
}
