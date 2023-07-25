package qaseapp.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaseapp.ui.model.User;
import qaseapp.ui.service.LoginPageService;
import qaseapp.ui.service.ProjectsPageService;
import qaseapp.ui.utils.Retry;

public class LoginPageTest extends BaseTest{
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void checkLoginTest() {
        User user = User.builder().email(System.getProperty("email")).password(System.getProperty("password")).build();
        ProjectsPageService projectsPageService = loginPageService.login(user);
        boolean isActualNameOfProjectsPageSectionDisplayed = projectsPageService.isActualNameOfProjectsPageSectionDisplayed();
        boolean isExpectedNameOfProjectsPageSectionDisplayed = true;
        Assert.assertEquals(isActualNameOfProjectsPageSectionDisplayed, isExpectedNameOfProjectsPageSectionDisplayed, "login isn't successful");
    }
}
