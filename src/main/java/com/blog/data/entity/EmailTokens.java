package com.blog.data.entity;

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
        @NamedQuery(name = "EmailTokens.updateEmailTokensByTokens" , query = "update EmailTokens set authAt = :authat, state = :state where token =:token"),
        @NamedQuery(name = "EmailTokens.checkEmailTokensByUserId" , query = "select e from EmailTokens e where e.user.id =:userId")
})
public class EmailTokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
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
