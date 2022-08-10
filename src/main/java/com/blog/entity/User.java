package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "User.findByEmail",query = "SELECT u FROM User u where u.email = :email"),
        @NamedQuery(name = "User.loginCheck",query = "SELECT u FROM User u where u.email = :email AND u.password = :password ")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Integer id;

    @Column(name = "email" ,nullable = false)
    private String email;

    @Column(name = "password" ,nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "user")
    private EmailTokens emailTokens;



}
