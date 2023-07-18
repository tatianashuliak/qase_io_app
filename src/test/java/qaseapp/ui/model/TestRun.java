package qaseapp.ui.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestRun {
    private String testRunName;
    private String description;
    private String testPlanName;
}
