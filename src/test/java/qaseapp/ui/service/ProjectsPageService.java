package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.model.Project;
import qaseapp.ui.page.ProjectsPage;

public class ProjectsPageService {
    private ProjectsPage projectsPage = new ProjectsPage();

    public boolean isActualNameOfProjectsPageSectionDisplayed () {
        return projectsPage.isNameOfProjectsPageSectionDisplayed();
    }

    @Step("User creates new project")
    public ProjectRepositoryPageService createNewProject(Project project) {
        projectsPage.clickCreateNewProjectButton()
                .fillInProjectNameField(project.getProjectName())
                .fillInProjectCodeField(project.getProjectCode())
                .clickCreateProjectButton();
                return new ProjectRepositoryPageService();
    }

    @Step("User goes to project repository page")
    public ProjectRepositoryPageService goToProjectRepositoryPage() {
        projectsPage.clickProjectLink();
        return new ProjectRepositoryPageService();
    }

    @Step("User goes to new project repository page")
    public  ProjectRepositoryPageService goToNewProjectRepositoryPage() {
        projectsPage.clickNewProjectLink();
        return  new ProjectRepositoryPageService();
    }
}
