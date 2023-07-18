package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import qaseapp.ui.model.TestCase;

@Log4j2
public class ProjectRepositoryPage extends Page {
    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement createSuiteLink;

    @FindBy(xpath = "//input[@id='title']")
    private WebElement nameOfSuiteField;

    @FindBy(xpath = "//input[@id='description']")
    private WebElement descriptionOfSuiteField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;

    @FindBy(xpath = "//span[contains(text(), 'Suite was successfully created')]")
    private WebElement suiteWasCreatedAlert;

    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement createTestCaseLink;

    @FindBy(xpath = "//*[contains(text(), 'Test case was created successfully!')]")
    private WebElement testCaseWasCreatedSuccessfulMessage;

    @FindBy(xpath = "//span[contains(text(), 'Test Plans')]")
    private WebElement testPlansLink;

    @FindBy(xpath = "//a[@title='Test Runs']/span")
    private WebElement testRunsLink;

    @FindBy(xpath = "//a[@title='Settings']")
    private WebElement settingsLink;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]/parent::button")
    private WebElement deleteProjectButton;

    @FindBy(xpath = "//div[@role='dialog']//span[contains(text(), 'Delete')]/parent::button")
    private WebElement confirmDeleteProjectButton;

    @FindBy(xpath = "//div[contains(text(), 'TestCaseTitle')]")
    private WebElement testCaseLink;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]/parent::button")
    private WebElement deleteTestCaseButton;

    @FindBy(xpath = "//*[contains(text(), 'Cancel')]/following::button")
    private WebElement confirmDeleteTestCaseButton;

    @FindBy(xpath = "//*[contains(text(), 'was successfully deleted')]")
    private WebElement testCaseWasSuccessfullyDeletedMessage;

    public boolean isCreateSuiteButtonDisplayed() {
        log.info("Search an element of page");
        return waitVisibilityOfElement(createSuiteLink).isDisplayed();
    }

    public ProjectRepositoryPage clickCreateSuiteButton() {
        log.info("Click create test suite button");
        waitElementToBeClickable(createSuiteLink).click();
        return this;
    }

    public ProjectRepositoryPage fillInNameOfSuiteField(String nameOfSuite) {
        log.info("Enter name of test suite");
        nameOfSuiteField.sendKeys(nameOfSuite);
        return this;
    }

    public ProjectRepositoryPage fillInDescriptionOfSuiteField(String descriptionOfSuite) {
        log.info("Enter description of test suite");
        descriptionOfSuiteField.sendKeys(descriptionOfSuite);
        return this;
    }

    public void clickCreateButton() {
        log.info("Click create test suite button");
        createButton.click();
    }

    public boolean isSuiteWasSuccessfulCreatedAlertDisplayed() {
        log.info("Search successful message of creating suite");
        return waitVisibilityOfElement(suiteWasCreatedAlert).isDisplayed();
    }

    public void clickCreateTestCaseLink() {
        log.info("Click create test case link");
        waitElementToBeClickable(createTestCaseLink).click();
    }

    public boolean isSuccessfulMessageDisplayed() {
        log.info("Search successful message of creating case");
        return waitVisibilityOfElement(testCaseWasCreatedSuccessfulMessage).isDisplayed();
    }

    public void clickTestPlansLink() {
        log.info("Click test plan link");
        waitElementToBeClickable(testPlansLink).click();
    }

    public void clickTestRunsLink() {
        log.info("Click test run link");
        waitElementToBeClickable(testRunsLink).click();
    }

    public ProjectRepositoryPage clickSettingsLink() {
        log.info("Click settings link");
        waitElementToBeClickable(settingsLink).click();
        return this;
    }

    public ProjectRepositoryPage clickDeleteProjectButton() {
        log.info("Click delete project button");
        waitElementToBeClickable(deleteProjectButton).click();
        return this;
    }

    public void clickConfirmDeleteProjectButton() {
        log.info("Click confirm delete project button");
        waitElementToBeClickable(confirmDeleteProjectButton).click();
    }

    public ProjectRepositoryPage clickTestCaseLink() {
        log.info("Click test case link");
        waitVisibilityOfElement(testCaseLink).click();
        return this;
    }

    public ProjectRepositoryPage clickDeleteTestCaseButton() {
        log.info("Click delete test case button");
        waitElementToBeClickable(deleteTestCaseButton).click();
        return this;
    }

    public ProjectRepositoryPage clickConfirmDeleteTestCaseButton() {
        log.info("Click confirm delete test case button");
        waitElementToBeClickable(confirmDeleteProjectButton).click();
        return this;
    }

    public boolean isTestCaseDeletedMessageDisplayed() {
        log.info("Search successful message of deleting test case");
        return waitVisibilityOfElement(testCaseWasSuccessfullyDeletedMessage).isDisplayed();
    }
}
