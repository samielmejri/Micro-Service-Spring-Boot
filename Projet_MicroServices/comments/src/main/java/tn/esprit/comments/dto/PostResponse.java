package tn.esprit.comments.dto;

import lombok.*;


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public class PostResponse {

        private String postId;
        private String username;
        private String title;
        private String content;
        private Long forumId;
}
