package com.dto;

import java.util.Date;

public class EditDTO implements DTO{

    private Integer userId;
    private String email;
    private Date editedAt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(Date editedAt) {
        this.editedAt = editedAt;
    }

    @Override
    public String toString() {
        return "EditDTO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", editedAt=" + editedAt +
                '}';
    }
}
