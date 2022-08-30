package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Setter
@Getter
@ToString
@NamedQueries({
        @NamedQuery(name = "Post.findAll",query = "select p from Post p")
})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Integer id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @ManyToOne
    private User user;
}
