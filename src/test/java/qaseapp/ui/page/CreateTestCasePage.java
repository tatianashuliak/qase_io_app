package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class CreateTestCasePage extends Page {
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleField;

    @FindBy(xpath = "//label[@for='0-status']/parent::div//input[@aria-autocomplete='list']")
    private WebElement statusField;

    @FindBy(xpath = "//label[@for='0-severity']/following-sibling::div//input[@aria-autocomplete='list']")
    private WebElement severityField;

    @FindBy(xpath = "//label[@for='0-priority']/following-sibling::div//input[@aria-autocomplete='list']")
    private WebElement priorityField;

    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement saveTestCaseButton;

    public CreateTestCasePage fillInTitleField(String title) {
        log.info("Enter title of test case");
        waitVisibilityOfElement(titleField).sendKeys(title);
        return this;
    }

    public CreateTestCasePage fillInStatusField(String status) {
        log.info("Enter status of test case");
        waitVisibilityOfElement(statusField).sendKeys(status);
        return this;
    }

    public CreateTestCasePage fillInSeverityField(String severity) {
        log.info("Enter severity of test case");
        waitVisibilityOfElement(severityField).sendKeys(severity);
        return this;
    }

    public CreateTestCasePage fillInPriorityField(String priority) {
        log.info("Enter priority of test case");
        waitVisibilityOfElement(priorityField).sendKeys(priority);
        return this;
    }

    public void clickSaveCaseButton() {
        log.info("Click save case button");
        saveTestCaseButton.click();
    }
}
