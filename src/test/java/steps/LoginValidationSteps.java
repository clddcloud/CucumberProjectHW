package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class LoginValidationSteps extends CommonMethods {

    @When("user click on login button")
    public void user_click_on_login_button() {
        click (loginValidationPage.loginButton);
    }

    @When("user enters {string} and {string}")
    public void userEntersAnd(String userName, String password) {
        sendText(userName, loginValidationPage.userNameField);
        sendText(password, loginValidationPage.passwordField);
    }

    @Then("user gets an {string} according to the type of incorrect data")
    public void userGetsAnAccordingToTheTypeOfIncorrectData(String error) {
        Assert.assertEquals(error, loginValidationPage.errorMessage.getText());
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

    @Then("user logins")
    public void userLogins() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }

}
