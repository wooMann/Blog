package com.dto;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Date;


public class DeleteDTO implements DTO{

    private Integer userId;
    private Integer email;
    private Date deletedAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "DeleteDTO{" +
                "userId=" + userId +
                ", email=" + email +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
