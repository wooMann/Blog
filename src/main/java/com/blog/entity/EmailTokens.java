package com.blog.entity;

import java.util.Date;

public class EmailTokens {
    private Integer id;
    private Integer userId;
    private String token;
    private Date authAt;
    private Integer state;
    private Date sendedAt;
    private Date deletedAt;

    @Override
    public String toString() {
        return "EmailTokens{" +
                "id=" + id +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", authAt=" + authAt +
                ", state=" + state +
                ", sendedAt=" + sendedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getAuthAt() {
        return authAt;
    }

    public void setAuthAt(Date authAt) {
        this.authAt = authAt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getSendedAt() {
        return sendedAt;
    }

    public void setSendedAt(Date sendedAt) {
        this.sendedAt = sendedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
