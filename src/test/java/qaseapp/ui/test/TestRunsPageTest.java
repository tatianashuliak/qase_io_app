package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.TestRun;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectsPageService;
import qaseapp.ui.service.TestPlansPageService;
import qaseapp.ui.service.TestRunsPageService;
import qaseapp.ui.utils.Retry;

public class TestRunsPageTest extends BaseTest {

    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private TestRunsPageService testRunsPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        testRunsPageService = new TestRunsPageService();

}

    @Test
    public void checkIsTestRunCreated() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        TestRun testRun = TestRun.builder().testRunName("Test Run").description("Test Run description").testPlanName("Test Plan").build();
        projectsPageService.goToProjectRepositoryPage()
                .goToTestRunsPage()
                .createTestRun(testRun);
        boolean isTestRunCreated = testRunsPageService.isTestRunCreated();
        Assert.assertTrue(isTestRunCreated);
    }

    @Test
    public void checkIsTestRunEdited() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        TestRun testRun = TestRun.builder().testRunName("New Test Run").build();
        projectsPageService.goToProjectRepositoryPage()
                .goToTestRunsPage()
                .editTestRun(testRun);
        boolean isTestRunEdited = testRunsPageService.isTestRunEdited();
        Assert.assertTrue(isTestRunEdited);
    }
    }
