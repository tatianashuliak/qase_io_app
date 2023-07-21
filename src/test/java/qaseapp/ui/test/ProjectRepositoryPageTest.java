package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.Suite;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectRepositoryPageService;
import qaseapp.ui.service.ProjectsPageService;
import qaseapp.ui.utils.Retry;


public class ProjectRepositoryPageTest extends BaseTest {
    private ProjectRepositoryPageService projectRepositoryPageService;
    private LoginPageService loginPageService;
    private ProjectsPageService projectsPageService;

    @BeforeClass
    public void setUp() {
        projectRepositoryPageService = new ProjectRepositoryPageService();
        loginPageService = new LoginPageService();
    }

    @Test
    public void checkIsSuiteCreated() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        Suite suite = Suite.builder()
                .nameOfSuite("TestSuite")
                .descriptionOfSuite("Test description")
                .build();
        boolean isSuiteCreated = projectsPageService.goToProjectRepositoryPage()
                .createNewSuite(suite.getNameOfSuite(), suite.getDescriptionOfSuite())
                .isSuiteCreated();
        Assert.assertTrue(isSuiteCreated, "Suite wasn't created");
    }

    @Test(dependsOnMethods = {"qaseapp.ui.test.ProjectsPageTest.checkIsNewProjectCreatedTest"})
    public void checkIsProjectDeleted() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        projectsPageService.goToNewProjectRepositoryPage()
                .deleteProject();
        boolean isProjectDeleted = projectsPageService.isActualNameOfProjectsPageSectionDisplayed();
        Assert.assertTrue(isProjectDeleted);
    }

    @Test(dependsOnMethods = {"qaseapp.ui.test.CreateTestCasePageTest.checkIsTestCaseCreated"})
    public void checkIsTestCaseDeleted() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        boolean isTestCaseDeleted = projectsPageService.goToProjectRepositoryPage()
                .deleteTestCase()
                .isTestCaseDeleted();
        Assert.assertTrue(isTestCaseDeleted);
    }
}
