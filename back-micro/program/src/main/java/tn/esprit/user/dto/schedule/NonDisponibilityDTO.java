package tn.esprit.user.dto.schedule;

import tn.esprit.user.entities.schedule.Period;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.DayOfWeek;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class NonDisponibilityDTO {
    private String  id;
    private DayOfWeek dayOfWeek;
    private Period period;
}
