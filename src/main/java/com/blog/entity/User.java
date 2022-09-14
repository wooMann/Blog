package com.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "User.findByEmail",query = "SELECT u FROM User u where u.email = :email"),
        @NamedQuery(name = "User.loginCheck",query = "SELECT u FROM User u where u.email = :email AND u.password = :password "),
        @NamedQuery(name = "User.findAllUser",query = "select u from User u")
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

    @Column(name = "created_at")
    private Date createdAt;



}
