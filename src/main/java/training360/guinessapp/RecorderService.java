package training360.guinessapp;

import lombok.AllArgsConstructor;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private ModelMapper modelMapper;
    private RecorderRepository recorderRepository;

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);

        return modelMapper.map(recorder,RecorderDto.class);
    }

    public List<RecorderShortDto> listRecordersByNameB() {

        Type targetListType = new TypeToken<List<RecorderShortDto>>(){}.getType();

        return modelMapper.map(recorderRepository.listRecordersByNameB(), targetListType);
    }
}
