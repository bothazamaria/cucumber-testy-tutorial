package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I access the login page.$")
    public void I_access_the_login_page() {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @Given("^I insert valid credentials.$")
    public void I_insert_valid_credentials() {
        I_enter_credentials("eu@fast.com", "eu.pass");
    }

    @When("^I click on login button.$")
    public void I_click_on_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^I check if the user was logged in.$")
    public void I_check_if_the_user_was_logged_in() {
        boolean successfullLogin = false;
        try {

            WebElement logoutButton = driver.findElement(By.xpath("//a[.='Logout']"));
            successfullLogin = logoutButton.isDisplayed();
        } catch (Exception e) {
        }
        assertThat("Logout button was not found!", successfullLogin, is(true));
    }

    @Given("^I insert invalid credentials.$")
    public void I_insert_invalid_credentials() {
        I_enter_credentials("euuu@fast.com", "eu.paaaass");

    }

    @Then("^I expect invalid credentials message.$")
    public void I_expect_invalid_credentials_message() {
        errorMessageShouldBePresent("Invalid user or password!");

    }

    private void errorMessageShouldBePresent(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.className("error-msg"));
        assertThat(errorMessage.getText(), is(expectedMessage));
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials.$")
    public void I_enter_credentials(String emailValue, String passwordValue) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailValue);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordValue);
    }

    @Then("^I expect \"([^\"]*)\" error message.$")
    public void I_expect_error_message(String expectedMessage) {
        errorMessageShouldBePresent(expectedMessage);
    }

    @Given("^I successfully login.$")
    public void I_successfully_login() {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_on_login_button();
        I_check_if_the_user_was_logged_in();
    }
}
