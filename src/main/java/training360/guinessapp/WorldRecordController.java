package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
@AllArgsConstructor
public class WorldRecordController {

    private WorldRecordService worldRecordService;

    @PostMapping
    public WorldRecordDto createWorldRecord(@RequestBody @Valid WorldRecordCreateCommand command) {
        return worldRecordService.createWorldRecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto beatWorldRecord(@PathVariable("id") long id, @RequestBody @Valid BeatWorldRecordCommand command) {
        return worldRecordService.beatWorldRecord(command, id);
    }


}
