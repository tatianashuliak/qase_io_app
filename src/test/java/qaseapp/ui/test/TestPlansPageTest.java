package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.TestPlan;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectsPageService;
import qaseapp.ui.service.TestPlansPageService;
import qaseapp.ui.utils.Retry;

public class TestPlansPageTest extends BaseTest {
    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;
    private TestPlansPageService testPlansPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        testPlansPageService = new TestPlansPageService();
    }

    @Test
    public void checkIsTestPlanCreated() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        TestPlan testPlan = TestPlan.builder()
                .title("Test Plan")
                .description("Description")
                .build();
        projectsPageService.goToProjectRepositoryPage()
                .goToTestPlansPage()
                .createTestPlan(testPlan);
        boolean isTestPlanCreated = testPlansPageService.isTestPlanCreated();
        Assert.assertTrue(isTestPlanCreated);
    }

    @Test
    public void checkIsTestPlanDeleted() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        projectsPageService.goToProjectRepositoryPage()
                .goToTestPlansPage()
                .deleteTestPlan();
        boolean isTestPlanDeleted = testPlansPageService.isTestPlanDeleted();
        Assert.assertTrue(isTestPlanDeleted);
    }
}
