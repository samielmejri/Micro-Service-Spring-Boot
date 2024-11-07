package tn.lastdance.posts.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long commentId;

    private String postId;

    private String username;

    private String content;


    private LocalDateTime createdAt;
}
