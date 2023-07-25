package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.TestCase;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectsPageService;



public class CreateTestCasePageTest extends BaseTest {
    private ProjectsPageService projectsPageService;
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        projectsPageService = new ProjectsPageService();
        loginPageService = new LoginPageService();
    }

    @Test
    public void checkIsTestCaseCreated() {
        User user = User.builder().email("tatjananikolaevich23041997@gmail.com").password("23041997nik").build();
        projectsPageService = loginPageService.login(user);
        TestCase testCase = TestCase.builder()
                .title("TestCaseTitle")
                .status("Actual")
                .severity("Normal")
                .priority("Medium")
                .build();
        boolean isTestCaseCreated = projectsPageService.goToProjectRepositoryPage()
                .goToCreateTestCasePage()
                .createTestCase(testCase)
                .isTestCaseCreated();
        Assert.assertTrue(isTestCaseCreated, "Test case isn't created");
    }
}
