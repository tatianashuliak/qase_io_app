package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.model.TestPlan;
import qaseapp.ui.page.TestPlansPage;

public class TestPlansPageService {
    private TestPlansPage testPlansPage = new TestPlansPage();

    @Step("User creates new test plan")
    public void createTestPlan(TestPlan testPlan) {
        testPlansPage.clickCreateTestPlanLink()
                .fillInTitleField(testPlan.getTitle())
                .fillInDescriptionField(testPlan.getDescription())
                .clickAddCasesButton()
                .checkTestCaseCheckBox()
                .clickDoneButton()
                .clickCreatePlanButton();
    }

    public boolean isTestPlanCreated() {
        return testPlansPage.isSuccessfulMessageDisplayed();
    }

    @Step("User deletes test plan")
    public void deleteTestPlan() {
        testPlansPage.clickMenuButton()
                .clickDeleteLink()
                .clickConfirmDeleteButton();
    }

    public boolean isTestPlanDeleted() {
        return testPlansPage.isSuccessfulDeletedMessageDisplayed();
    }
}
