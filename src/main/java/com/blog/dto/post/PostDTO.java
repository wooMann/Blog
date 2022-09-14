package com.blog.dto.post;

import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDTO {

    private Integer id;
    private String body;
    private String title;
    private Integer userId;

    public Post makePost(){
        return Post.builder()
                .id(getId())
                .body(getBody())
                .title(getTitle())
                .user(User.builder().id(getUserId()).build())
                .build();
    }


}
