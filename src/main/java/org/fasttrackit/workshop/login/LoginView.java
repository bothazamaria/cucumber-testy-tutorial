package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator loginButton = new WebLocator().setId("loginButton");
    private WebLocator email = new WebLocator().setId("email");
    private WebLocator password = new WebLocator().setId("password");
    private WebLocator errorMessage = new WebLocator().setElPath("//div[@class = 'error-msg error']");
    private WebLocator logoutButton = new WebLocator().setElPath("//a[.='Logout']");

    public void clickLoginButton() {
        loginButton.click();
    }

    public void insertCredentials(String emailValue, String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
    }

    public String getErrorMessage() {
        return errorMessage.getHtmlText();
    }

    public boolean checkLogoutButtonIsDisplayed() {
        return logoutButton.isElementPresent();
    }
}
