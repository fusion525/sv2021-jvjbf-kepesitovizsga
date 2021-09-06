package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recorders")
@AllArgsConstructor
public class RecorderController {

    private RecorderService recorderService;

    @PostMapping
    public RecorderDto createRecorder(@RequestBody @Valid RecorderCreateCommand command) {
        return recorderService.createRecorder(command);
    }

    @GetMapping
    public List<RecorderShortDto> listRecordersByNameB() {
        return recorderService.listRecordersByNameB();
    }

}
