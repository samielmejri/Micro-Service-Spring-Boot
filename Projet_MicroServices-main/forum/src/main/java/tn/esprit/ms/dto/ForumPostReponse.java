package tn.esprit.ms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
public class ForumPostReponse {
    List<PostResponse> postResponses;
    private Long id;
    private String titre;
    private String description;
}
