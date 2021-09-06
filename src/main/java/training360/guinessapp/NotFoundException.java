package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {

    public NotFoundException() {
        super(
                URI.create("/api/worldrecords"),
                "Recorder not found",
                Status.NOT_FOUND,
                String.format("Recorder not found"));
    }

}