package qaseapp.ui.service;

import qaseapp.ui.model.TestRun;
import qaseapp.ui.page.TestRunsPage;

public class TestRunsPageService {

    TestRunsPage testRunsPage = new TestRunsPage();

    public void createTestRun(TestRun testRun) {
        testRunsPage.clickStartNewTestRunButton()
                .fillInTestRunNameField(testRun.getTestRunName())
                .fillInTestRunDescriptionField(testRun.getDescription())
                .clickTestsFromATestPlanRadioButton()
                .chooseTestPlan(testRun.getTestPlanName())
                .clickStartARunButton();
    }

    public boolean isTestRunCreated() {
        return testRunsPage.isCompleteRunButtonDisplayed();
    }

    public void editTestRun(TestRun testRun) {
        testRunsPage.clickMenuLink()
                .clickEditRunLink()
                .editTestRunName(testRun.getTestRunName())
                .clickUpdateTestRunButton();
    }

    public boolean isTestRunEdited() {
        return testRunsPage.isSuccessfulEditedMessageDisplayed();
    }
}
