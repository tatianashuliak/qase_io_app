package qaseapp.ui.service;

import qaseapp.ui.page.ProjectRepositoryPage;

public class ProjectRepositoryPageService {
    ProjectRepositoryPage projectRepositoryPage = new ProjectRepositoryPage();
    public boolean isNewProjectCreated () {
        return projectRepositoryPage.isCreateSuiteButtonDisplayed();
    }
}
