package qaseapp.ui.service;

import qaseapp.ui.model.TestPlan;
import qaseapp.ui.page.TestPlansPage;

public class TestPlansPageService {

    TestPlansPage testPlansPage = new TestPlansPage();

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

    public void deleteTestPlan() {
        testPlansPage.clickMenuButton()
                .clickDeleteLink()
                .clickConfirmDeleteButton();
    }

    public boolean isTestPlanDeleted() {
        return testPlansPage.isSuccessfulDeletedMessageDisplayed();
    }
}
