package com.blog.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "post_tag")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;


}
