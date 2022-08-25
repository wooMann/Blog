package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    private Posts posts;

    @ManyToOne
    private User user;

    @Column(name = "user_ip")
    private String userIp;

    @ManyToOne
    private Comment comment;
}
