package qaseapp.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectRepositoryPage extends Page {
    @FindBy (xpath = "//a[@id='create-suite-button']")
    private WebElement createSuiteButton;

    public boolean isCreateSuiteButtonDisplayed() {
        return waitVisibilityOfElement(createSuiteButton).isDisplayed();
    }
}
