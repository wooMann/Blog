package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "email_tokens")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "EmailTokens.updateByTokens",query = "UPDATE  ")
})
public class EmailTokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Integer id;

    @OneToOne
    @JoinColumn()
    private User user;

    @Column(name = "token")
    private String token;

    @Column(name = "auth_at")
    private Date authAt;

    @Column(name = "state")
    private Integer state;

    @Column(name = "sended_at")
    private Date sendedAt;


}
