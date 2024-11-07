package tn.esprit.ms.dto;

import lombok.*;
import org.springframework.data.annotation.Id;


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
