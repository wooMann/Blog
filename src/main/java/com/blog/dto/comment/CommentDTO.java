package com.blog.dto.comment;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
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

    public Comment makeComment(){
        Comment comment = new Comment();
        comment.setBody(getBody());
        Post post = new Post();
        post.setId(getPostId());
        comment.setPost(post);

        if(getUserId() != null){
            User user = new User();
            user.setId(getUserId());
            comment.setUser(user);
        }
        comment.setUserIp(getUserIp());
        return comment;
    }
}
