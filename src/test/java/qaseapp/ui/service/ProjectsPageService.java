package qaseapp.ui.service;

import qaseapp.ui.model.Project;
import qaseapp.ui.page.ProjectsPage;

public class ProjectsPageService {
    ProjectsPage projectsPage = new ProjectsPage();

    public boolean isActualNameOfProjectsPageSectionDisplayed () {
        return projectsPage.isNameOfProjectsPageSectionDisplayed();
    }

    public ProjectRepositoryPageService createNewProject(Project project) {
        projectsPage.clickCreateNewProjectButton()
                .fillInProjectNameField(project.getProjectName())
                .fillInProjectCodeField(project.getProjectCode())
                .clickCreateProjectButton();
                return new ProjectRepositoryPageService();
    }
}
