package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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

    @FindBy(xpath = "//a[contains(text(), 'Test')]")
    private WebElement projectLink;

    @FindBy(xpath = "//a[contains(text(), 'Test1')]")
    private WebElement newProjectLink;

    public boolean isNameOfProjectsPageSectionDisplayed() {
        log.info("Search element of Projects page");
        return nameOfProjectsPageSection.isDisplayed();
    }

    public ProjectsPage clickCreateNewProjectButton() {
        log.info("Click create new project button");
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }

    public ProjectsPage fillInProjectNameField(String projectName) {
        log.info("Enter name of project");
        waitVisibilityOfElement(projectNameField).sendKeys(projectName);
        return this;
    }

    public ProjectsPage fillInProjectCodeField(String projectCode) {
        log.info("Enter code of project");
        waitVisibilityOfElement(projectCodeField).sendKeys(projectCode);
        return this;
    }

    public ProjectsPage clickCreateProjectButton() {
        log.info("Click create project button");
        waitElementToBeClickable(createProjectButton).click();
        return this;
    }

    public void clickProjectLink() {
        log.info("Click project link");
        waitElementToBeClickable(projectLink).click();
    }

    public void clickNewProjectLink() {
        log.info("Click new project link");
        waitElementToBeClickable(newProjectLink).click();
    }
}
