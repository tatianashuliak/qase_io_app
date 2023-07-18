package qaseapp.ui.model;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Data
@Builder
public class TestCase {
    private String title;
    private String status;
    private String severity;
    private String priority;
}
