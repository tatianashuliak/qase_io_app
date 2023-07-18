package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TestPlansPage extends Page{
    @FindBy(xpath = "//a[@id='createButton']")
    private WebElement createTestPlanLink;

    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleField;

    @FindBy(xpath = "//p[@data-placeholder]")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[@id='edit-plan-add-cases-button']")
    private WebElement addCasesButton;

    @FindBy(xpath = "//button[@id='save-plan']")
    private WebElement createPlanButton;

    @FindBy(xpath = "//div[@id='suite-0-checkbox']//span[@class='custom-control-indicator']")
    private WebElement testCaseCheckBox;

    @FindBy(xpath = "//span[text()= 'Done']/parent::button")
    private WebElement doneButton;

    @FindBy(xpath = "//span[contains(text(), 'Test plan was created successfully!')]")
    private WebElement successfulMessage;

    @FindBy(xpath = "//a[contains(text(), 'Test Plan')]/ancestor::tr//button")
    private WebElement menuButton;

    @FindBy(xpath = "//li[contains(text(), 'Delete')]")
    private WebElement deleteTestPlanLink;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]/parent::button")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//*[contains(text(), 'was deleted successfully!')]")
    private WebElement successfulDeletedMessage;

    public TestPlansPage clickCreateTestPlanLink() {
        log.info("Click create test plan link");
        waitElementToBeClickable(createTestPlanLink).click();
        return this;
    }

    public TestPlansPage fillInTitleField(String title) {
        log.info("Enter title of test plan");
        waitVisibilityOfElement(titleField).sendKeys(title);
        return this;
    }

    public TestPlansPage fillInDescriptionField(String description) {
        log.info("Enter description of test plan");
        waitVisibilityOfElement(descriptionField).sendKeys(description);
        return this;
    }

    public TestPlansPage clickAddCasesButton() {
        log.info("Click add cases to test plan button");
        waitElementToBeClickable(addCasesButton).click();
        return this;
    }

    public TestPlansPage checkTestCaseCheckBox() {
        log.info("Checking test case checkbox");
        waitElementToBeClickable(testCaseCheckBox).click();
        return this;
    }

    public TestPlansPage clickDoneButton() {
        log.info("Click done button");
        waitElementToBeClickable(doneButton).click();
        return this;
    }

    public void clickCreatePlanButton() {
        log.info("Click create test plan button");
        waitElementToBeClickable(createPlanButton).click();
    }

    public boolean isSuccessfulMessageDisplayed(){
        log.info("Search successful message of creating test plan");
        return waitVisibilityOfElement(successfulMessage).isDisplayed();
    }

    public TestPlansPage clickMenuButton() {
        log.info("Click menu button");
        waitElementToBeClickable(menuButton).click();
        return this;
    }

    public TestPlansPage clickDeleteLink() {
        log.info("Click delete test plan button");
        waitElementToBeClickable(deleteTestPlanLink).click();
        return this;
    }

    public void clickConfirmDeleteButton() {
        log.info("Click confirm delete button");
        waitElementToBeClickable(confirmDeleteButton).click();
    }

    public boolean isSuccessfulDeletedMessageDisplayed() {
        log.info("Search successful message of deleting test plan");
        return waitVisibilityOfElement(successfulDeletedMessage).isDisplayed();
    }
}
