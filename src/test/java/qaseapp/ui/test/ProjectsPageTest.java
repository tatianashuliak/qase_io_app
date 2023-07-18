package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.Project;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectRepositoryPageService;
import qaseapp.ui.service.ProjectsPageService;
import qaseapp.ui.utils.Retry;

public class ProjectsPageTest extends BaseTest {
    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
    }

    @Test
    public void checkIsNewProjectCreatedTest() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
       projectsPageService = loginPageService.login(user);
        Project project = Project.builder().projectName("Test").projectCode("Test").build();
        ProjectRepositoryPageService projectRepositoryPageService = projectsPageService.createNewProject(project);
        boolean isNewProjectCreated = projectRepositoryPageService.isNewProjectCreated();
        Assert.assertTrue(isNewProjectCreated);
    }
}
