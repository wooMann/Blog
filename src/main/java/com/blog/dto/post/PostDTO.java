package com.blog.dto.post;

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
    private Integer postId;
    private String userIp;
}
