package com.blog.dto.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {

    private Integer id;
    private String body;
    private Integer postId;
    private Integer userId;
    private Integer commentId;
    private String userIp;
}
