package com.blog.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "Comment.findByPostId",query = "select c from Comment c where c.post.id = :postId")
})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    @Column(name = "user_ip")
    private String userIp;


}
