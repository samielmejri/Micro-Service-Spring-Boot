package tn.lastdance.posts.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentResponse {
    List<CommentResponse> comments;
    private String postId;
    private String username;
    private String title;
    private String content;
    private Long forumId;
}
