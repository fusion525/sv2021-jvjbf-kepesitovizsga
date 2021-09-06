package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.TimeConstraint;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecorderCreateCommand {

    @NotBlank(message = "must not be blank")
    private String name;
    @TimeConstraint
    private LocalDate DateOfBirth;

}
