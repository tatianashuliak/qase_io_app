package qaseapp.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends Page {
    @FindBy(xpath = "//h1[text()='Projects']")
    private WebElement nameOfProjectsPageSection;

    @FindBy(xpath = "//button[@id='createButton']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement projectNameField;

    @FindBy(xpath = "//input[@id='project-code']")
    private WebElement projectCodeField;

    @FindBy(xpath = "//span[text()='Create project']")
    private WebElement createProjectButton;

    public boolean isNameOfProjectsPageSectionDisplayed() {
        return nameOfProjectsPageSection.isDisplayed();
    }

    public ProjectsPage clickCreateNewProjectButton() {
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }

    public ProjectsPage fillInProjectNameField(String projectName) {
        waitVisibilityOfElement(projectNameField).sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillInProjectCodeField(String projectCode) {
        waitVisibilityOfElement(projectCodeField).sendKeys(projectCode);
        return this;
    }

    public ProjectsPage clickCreateProjectButton() {
        waitElementToBeClickable(createProjectButton).click();
        return this;
    }
}
