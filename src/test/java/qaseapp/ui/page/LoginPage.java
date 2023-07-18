package qaseapp.ui.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends Page{
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmail (String email) {
        log.info("Enter email");
        waitVisibilityOfElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPassword (String password) {
        log.info("Enter password");
        waitVisibilityOfElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        log.info("Click sign in button");
        waitElementToBeClickable(signInButton).click();
    }
}
