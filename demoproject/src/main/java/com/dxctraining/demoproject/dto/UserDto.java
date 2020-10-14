package com.dxctraining.demoproject.dto;

public class UserDto {

    private Integer userId;
    private String name;
    private String description;
    private long startDate;
    private long endDate;
    private String status;

    public UserDto(){

    }

    public UserDto(Integer userId, String name, String description, long startDate, long endDate, String status){
        this.userId=userId;
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.status=status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
