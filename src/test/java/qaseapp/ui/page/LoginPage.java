package qaseapp.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        waitVisibilityOfElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPassword (String password) {
        waitVisibilityOfElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        waitElementToBeClickable(signInButton).click();
    }
}
