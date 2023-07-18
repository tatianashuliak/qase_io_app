package qaseapp.ui.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestPlan {
    private String title;
    private String description;
}
