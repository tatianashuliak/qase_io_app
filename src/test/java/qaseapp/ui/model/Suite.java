package qaseapp.ui.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    private String nameOfSuite;
    private String descriptionOfSuite;
}
