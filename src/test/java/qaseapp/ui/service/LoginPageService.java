package qaseapp.ui.service;

import qaseapp.ui.model.User;
import qaseapp.ui.page.LoginPage;

public class LoginPageService {

    protected static final String LOGIN_PAGE_URL = "https://app.qase.io/login";

    public ProjectsPageService login(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSignInButton();
        return new ProjectsPageService();
    }
}
