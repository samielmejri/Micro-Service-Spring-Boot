package tn.esprit.ms.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//@Data
//@Builder
//@Document(collation = "posts")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    private String postId;
    private String username;
    private String title;
    private String content;
    private Long forumId;

}
