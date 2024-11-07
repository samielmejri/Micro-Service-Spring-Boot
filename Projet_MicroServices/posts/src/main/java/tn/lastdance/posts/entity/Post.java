package tn.lastdance.posts.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@Builder
//@Document(collation = "posts")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "posts")
@Builder
@Getter
@Setter
public class Post {
    @Id
    private String postId;
    private String username;
    private String title;
    private String content;
    private Long forumId;
}
