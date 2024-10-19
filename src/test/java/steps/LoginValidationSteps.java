package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;

public class LoginValidationSteps extends CommonMethods {
    @When("user enters valid password")
    public void user_enters_valid_password() throws IOException {
        sendText(ConfigReader.read("password"), loginValidationPage.passwordField);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        click (loginValidationPage.loginButton);
    }

    @Then("user gets an error message: Username cannot be empty.")
    public void user_gets_an_error_message_username_cannot_be_empty() {
       Assert.assertEquals("Username cannot be empty", loginValidationPage.errorMessage.getText());
    }

    @Then("user can enter both username and password again")
    public void user_can_enter_both_username_and_password_again() {
        boolean cond=false;
        if (loginValidationPage.userNameField.isDisplayed() &&
        loginValidationPage.userNameField.isEnabled() &&
        loginValidationPage.passwordField.isDisplayed() &&
        loginValidationPage.passwordField.isEnabled()){
            cond=true;
        }
        Assert.assertTrue(cond);

    }

    @When("user enters valid username")
    public void user_enters_valid_username() throws IOException {
        sendText(ConfigReader.read("username"), loginValidationPage.userNameField);
    }

    @Then("user gets an error message: Password is empty.")
    public void user_gets_an_error_message_password_is_empty() {
        Assert.assertEquals("Password is Empty", loginValidationPage.errorMessage.getText());
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() throws IOException {
        sendText(ConfigReader.read("invalidUsername"), loginValidationPage.userNameField);
    }

    @Then("user gets an error message: Invalid credentials.")
    public void user_gets_an_error_message_invalid_credentials() {
        Assert.assertEquals("Invalid credentials", loginValidationPage.errorMessage.getText());
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() throws IOException {
        sendText(ConfigReader.read("invalidPassword"), loginValidationPage.passwordField);
    }

    @Then("user logins")
    public void userLogins() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }
}
