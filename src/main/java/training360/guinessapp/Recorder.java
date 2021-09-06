package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recorder")
public class Recorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate DateOfBirth;

    public Recorder(String name, LocalDate dateOfBirth) {
        this.name = name;
        DateOfBirth = dateOfBirth;
    }
}
