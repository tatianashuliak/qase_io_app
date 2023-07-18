package qaseapp.ui.service;

import qaseapp.ui.page.ProjectRepositoryPage;

public class ProjectRepositoryPageService {
    ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();

    public boolean isNewProjectCreated() {
        return projectRepositoryPage.isCreateSuiteButtonDisplayed();
    }

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

    public CreateTestCasePageService goToCreateTestCasePage() {
        projectRepositoryPage.clickCreateTestCaseLink();
        return new CreateTestCasePageService();
    }

    public boolean isTestCaseCreated() {
        return projectRepositoryPage.isSuccessfulMessageDisplayed();
    }

    public TestPlansPageService goToTestPlansPage() {
        projectRepositoryPage.clickTestPlansLink();
        return new TestPlansPageService();
    }

    public TestRunsPageService goToTestRunsPage() {
        projectRepositoryPage.clickTestRunsLink();
        return new TestRunsPageService();
    }

    public ProjectsPageService deleteProject() {
        projectRepositoryPage.clickSettingsLink()
                .clickDeleteProjectButton()
                .clickConfirmDeleteProjectButton();
        return new ProjectsPageService();
    }

    public void deleteTestCase() {
        projectRepositoryPage.clickTestCaseLink()
                .clickDeleteTestCaseButton()
                .clickConfirmDeleteTestCaseButton();
    }

    public boolean isTestCaseDeleted() {
        return projectRepositoryPage.isTestCaseDeletedMessageDisplayed();
    }
}

