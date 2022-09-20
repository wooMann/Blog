package com.blog.data.dto.comment;

import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
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
