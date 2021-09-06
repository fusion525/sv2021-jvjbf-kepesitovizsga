package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;
    private WorldRecordRepository worldRecordRepository;
    private RecorderRepository recorderRepository;


    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {

        if (!recorderRepository.existsById(command.getRecorderId())) {
            throw new NotFoundException();
        }

        Recorder recorder = recorderRepository.getById(command.getRecorderId());

        WorldRecord worldRecord = new WorldRecord(command.getDescription(),command.getValue(),
                command.getUnitOfMeasure(),command.getDateOfRecord(),command.getRecorderId());

        worldRecordRepository.save(worldRecord);

        return new WorldRecordDto(worldRecord.getId(), worldRecord.getDescription(), worldRecord.getValue(),
                worldRecord.getUnitOfMeasure(),worldRecord.getDateOfRecord(), recorder.getName());
    }

    public BeatWorldRecordDto beatWorldRecord(BeatWorldRecordCommand command, long id) {
        WorldRecord worldRecord = worldRecordRepository.getById(id);

        Double difference = command.getNewRecordValue() - worldRecord.getValue();
        String oldRecorderName = recorderRepository.getRecorderName(worldRecord.getRecorderId());
        String description = worldRecord.getDescription();
        String unitOfMeasure = worldRecord.getUnitOfMeasure();
        Double oldValue = worldRecord.getValue();
        String newRecorder = recorderRepository.getRecorderName(command.getRecorderId());
        Double newValue = command.getNewRecordValue();

        worldRecord.setRecorderId(command.getRecorderId());
        worldRecord.setValue(command.getNewRecordValue());
        worldRecordRepository.save(worldRecord);

        return new BeatWorldRecordDto(description,unitOfMeasure,oldRecorderName,oldValue,newRecorder,
                newValue,difference);
    }
}
