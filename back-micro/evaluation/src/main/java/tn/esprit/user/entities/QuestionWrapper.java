package tn.esprit.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class QuestionWrapper {

    private String _id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
