package qaseapp.ui.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String projectName;
    private String projectCode;
}
