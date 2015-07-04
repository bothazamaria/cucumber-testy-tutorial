package org.fasttrackit.workshop.pagefactory.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "loginButton")
    private WebElement loginButton;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//div[@class = 'error-msg error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//a[.='Logout']")
    private WebElement logoutButton;

    public void ClickLoginButton() {
        loginButton.click();
    }

    public void insertCredentials(String emailValue, String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean checkLogoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }
}
