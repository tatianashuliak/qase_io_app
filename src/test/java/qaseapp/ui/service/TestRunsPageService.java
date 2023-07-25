package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.model.TestRun;
import qaseapp.ui.page.TestRunsPage;

public class TestRunsPageService {
    private TestRunsPage testRunsPage = new TestRunsPage();

    @Step("User creates new test run")
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

    @Step("User edits test run")
    public TestRunsPageService editTestRun(TestRun testRun) {
        testRunsPage.clickMenuLink()
                .clickEditRunLink()
                .editTestRunName(testRun.getTestRunName())
                .clickUpdateTestRunButton();
        return this;
    }

    public boolean isTestRunEdited() {
        return testRunsPage.isSuccessfulEditedMessageDisplayed();
    }
}
