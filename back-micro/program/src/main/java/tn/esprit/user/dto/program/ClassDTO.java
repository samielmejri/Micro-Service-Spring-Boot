package tn.esprit.user.dto.program;

import tn.esprit.user.entities.User;
import tn.esprit.user.entities.schedule.FieldOfStudy;
import tn.esprit.user.entities.schedule.Modul;
import tn.esprit.user.entities.schedule.Semester;
import lombok.Data;

import java.util.List;

@Data
public class ClassDTO {
    private String id;
    private String name;
    private Integer capacity;
    private List<User> teachers;
    private List<Modul> moduls;
    private FieldOfStudy fieldOfStudy;
    private Semester semester;
}
