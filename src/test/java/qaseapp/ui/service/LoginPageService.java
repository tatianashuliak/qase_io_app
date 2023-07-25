package qaseapp.ui.service;

import io.qameta.allure.Step;
import qaseapp.ui.model.User;
import qaseapp.ui.page.LoginPage;

public class LoginPageService {
    protected static final String LOGIN_PAGE_URL = "https://app.qase.io/login";
    @Step("User logins with password and email")
    public ProjectsPageService login(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSignInButton();
        return new ProjectsPageService();
    }
}
