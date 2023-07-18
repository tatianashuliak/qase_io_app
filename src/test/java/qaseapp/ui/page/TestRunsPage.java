package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TestRunsPage extends Page {
    @FindBy(xpath = "//span[contains(text(), 'Start new')]/parent::button")
    private WebElement startNewTestRunButton;

    @FindBy(xpath = "//input[@title='Title']")
    private WebElement testRunNameField;

    @FindBy(xpath = "//input[@id='description']/parent::div//p")
    private WebElement testRunDescriptionField;

    @FindBy(xpath = "//input[@value='plan']")
    private WebElement testsFromATestPlanRadioButton;

    @FindBy(xpath = "//span[(text()='Tests')]//parent::div//input[@aria-autocomplete='list']")
    private WebElement testPlanNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement startARunButton;

    @FindBy(xpath = "//span[contains(text(), 'Complete')]/parent::button")
    private WebElement completeRunButton;

    @FindBy(xpath = "//div[@class='dropdown']/a")
    private WebElement menuLink;

    @FindBy(xpath = "//span[contains(text(), 'Edit run')]")
    private WebElement editRunLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement updateTestRunButton;

    @FindBy(xpath = "//*[contains(text(), 'Run was edited successfully')]")
    private WebElement successfulEditedMessage;

    public TestRunsPage clickStartNewTestRunButton() {
        log.info("Click start new test run button");
        waitElementToBeClickable(startNewTestRunButton).click();
        return this;
    }

    public TestRunsPage fillInTestRunNameField(String testRunName) {
        log.info("Enter name of test run");
        waitVisibilityOfElement(testRunNameField).sendKeys(testRunName);
        return this;
    }

    public TestRunsPage fillInTestRunDescriptionField(String description) {
        log.info("Enter description of test run");
        waitVisibilityOfElement(testRunDescriptionField).sendKeys(description);
        return this;
    }

    public TestRunsPage clickTestsFromATestPlanRadioButton() {
        log.info("Check radio button");
        Actions action= new Actions(driver);
        action.moveToElement(testsFromATestPlanRadioButton).build().perform();
        testsFromATestPlanRadioButton.click();
        return this;
    }

    public TestRunsPage chooseTestPlan(String testPlanName) {
        log.info("Choose a test plan");
        testPlanNameField.sendKeys(testPlanName);
        testPlanNameField.sendKeys(Keys.ARROW_DOWN);
        testPlanNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public TestRunsPage clickStartARunButton() {
        log.info("Click start a run button");
        waitElementToBeClickable(startARunButton).click();
        return this;
    }

    public boolean isCompleteRunButtonDisplayed() {
        log.info("Search complete run button on page");
        return waitVisibilityOfElement(completeRunButton).isDisplayed();
    }

    public TestRunsPage clickMenuLink() {
        log.info("Click menu link");
        waitVisibilityOfElement(menuLink).click();
        return this;
    }

    public TestRunsPage clickEditRunLink() {
        log.info("Click edit run link");
        waitVisibilityOfElement(editRunLink).click();
        return this;
    }

    public TestRunsPage editTestRunName(String newTestRunName) {
        log.info("Enter new test run name");
        waitVisibilityOfElement(testRunNameField).clear();
        testRunNameField.sendKeys(newTestRunName);
        return this;
    }

    public void clickUpdateTestRunButton() {
        log.info("Click update test run button");
        waitElementToBeClickable(updateTestRunButton).click();
    }

    public boolean isSuccessfulEditedMessageDisplayed() {
        log.info("Search successful message of editing test run");
        return waitVisibilityOfElement(successfulEditedMessage).isDisplayed();
    }

}
