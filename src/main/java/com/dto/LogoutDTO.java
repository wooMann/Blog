package com.dto;

import java.util.Date;

public class LogoutDTO implements DTO{
    private Integer userId;
    private Date logoutAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(Date logoutAt) {
        this.logoutAt = logoutAt;
    }

    @Override
    public String toString() {
        return "LogoutDTO{" +
                "userId=" + userId +
                ", logoutAt=" + logoutAt +
                '}';
    }
}
