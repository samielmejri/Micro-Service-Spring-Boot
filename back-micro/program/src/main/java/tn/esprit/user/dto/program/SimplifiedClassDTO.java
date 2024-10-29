package tn.esprit.user.dto.program;

import tn.esprit.user.entities.institution.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedClassDTO {
    private String id;
    private String name;

    public SimplifiedClassDTO(Class stclass) {
        this.id = stclass.getId();
        this.name = stclass.getName();
    }
}
