package qaseapp.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    private String title;
    private String description;
    private int severity;
    private int priority;
    private int status;

}
