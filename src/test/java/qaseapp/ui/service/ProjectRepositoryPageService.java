package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.page.ProjectRepositoryPage;

public class ProjectRepositoryPageService {
    private ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();

    public boolean isNewProjectCreated() {
        return projectRepositoryPage.isCreateSuiteButtonDisplayed();
    }
    @Step("User create new test suite")
    public ProjectRepositoryPageService createNewSuite(String nameOfSuite, String descriptionOfSuite) {
        projectRepositoryPage.clickCreateSuiteButton()
                .fillInNameOfSuiteField(nameOfSuite)
                .fillInDescriptionOfSuiteField(descriptionOfSuite)
                .clickCreateButton();
        return this;
    }

    public boolean isSuiteCreated() {
        return projectRepositoryPage.isSuiteWasSuccessfulCreatedAlertDisplayed();
    }

    @Step("User goes to creating test case page")
    public CreateTestCasePageService goToCreateTestCasePage() {
        projectRepositoryPage.clickCreateTestCaseLink();
        return new CreateTestCasePageService();
    }

    public boolean isTestCaseCreated() {
        return projectRepositoryPage.isSuccessfulMessageDisplayed();
    }

    @Step("User goes to test plans page")
    public TestPlansPageService goToTestPlansPage() {
        projectRepositoryPage.clickTestPlansLink();
        return new TestPlansPageService();
    }

    @Step("User goes to test runs page")
    public TestRunsPageService goToTestRunsPage() {
        projectRepositoryPage.clickTestRunsLink();
        return new TestRunsPageService();
    }

    @Step("User deletes project")
    public ProjectsPageService deleteProject() {
        projectRepositoryPage.clickSettingsLink()
                .clickDeleteProjectButton()
                .clickConfirmDeleteProjectButton();
        return new ProjectsPageService();
    }
    @Step("User deletes test case")
    public ProjectRepositoryPageService deleteTestCase() {
        projectRepositoryPage.clickTestCaseLink()
                .clickDeleteTestCaseButton()
                .clickConfirmDeleteTestCaseButton();
        return this;
    }

    public boolean isTestCaseDeleted() {
        return projectRepositoryPage.isTestCaseDeletedMessageDisplayed();
    }
}

