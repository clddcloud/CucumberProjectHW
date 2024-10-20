package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    private String firstNameProvided;
    private String lastNameProvided;
    private String idProvided;
    private String addEmployeePageUrl;

    @When("user clicks on PIM")
    public void user_clicks_on_pim() {
        click (dashboardPage.pimButton);
    }

    @When("user clicks on Add Employee")
    public void user_clicks_on_add_employee() {
        click (dashboardPage.addEmployeeButton);
    }

    @When("user is able to enter middlename")
    public void user_is_able_to_enter_middlename() {
        Assert.assertTrue(addEmployeePage.middleNameField.isDisplayed()&& addEmployeePage.middleNameField.isEnabled());
    }

    @When("user see that ID is autogenerated")
    public void user_see_that_id_is_autogenerated() {
        Assert.assertNotEquals(null, addEmployeePage.employeeIdField.getAttribute("value"));
        idProvided=addEmployeePage.employeeIdField.getAttribute("value");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       click(addEmployeePage.saveButton);
    }

    @Then("new page is opened")
    public void new_page_is_opened() {
        Assert.assertNotEquals(driver.getCurrentUrl(), addEmployeePageUrl);
    }

    @Then("user can see new employee added with firstname and lastname entered and ID")
    public void user_can_see_new_employee_added_with_firstname_and_lastname_entered_and_id()  {
       Assert.assertEquals(firstNameProvided, personalDetailsPage.firstNameField.getAttribute("value"));
       Assert.assertEquals(lastNameProvided, personalDetailsPage.lastNameField.getAttribute("value"));
       Assert.assertEquals(idProvided, personalDetailsPage.idField.getAttribute("value"));
    }

    @When("user enters ID")
    public void user_enters_id() {
        idProvided = String.valueOf(randomID());
        sendText(idProvided, addEmployeePage.employeeIdField);
    }

    @And("new employee is not created")
    public void newEmployeeIsNotCreated() {
        Assert.assertEquals(driver.getCurrentUrl(), addEmployeePageUrl);
    }

    @Then("user see required firstname")
    public void userSeeRequiredFirstname() {
        Assert.assertEquals(addEmployeePage.firstNameField.getAttribute("class"),"formInputText validation-error");

    }

    @Then("user see required lastname")
    public void userSeeRequiredLastname() {
        Assert.assertEquals(addEmployeePage.lastNameField.getAttribute("class"),"formInputText validation-error");

    }

    @Then("user sees an error message")
    public void userSeesAnErrorMessage() {
        Assert.assertTrue(addEmployeePage.warningMsg.isDisplayed());
    }

    @And("user enters a {string}")
    public void userEntersA(String id) {
        sendText(id, addEmployeePage.employeeIdField);
    }

    @Then("user is navigated to the Add Employee page")
    public void userIsNavigatedToTheAddEmployeePage() {
        addEmployeePageUrl =driver.getCurrentUrl();
    }

    @When("user enters employees {string} and {string}")
    public void userEntersEmployeesAnd(String firstName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        firstNameProvided=firstName;
        sendText(lastName, addEmployeePage.lastNameField);
        lastNameProvided=lastName;
    }

    @Then("user see required {string}")
    public void userSeeRequired(String message) {
        if (firstNameProvided==null) {
            Assert.assertTrue(addEmployeePage.firstNameErrorMsg.isDisplayed());
            Assert.assertEquals(message, addEmployeePage.firstNameErrorMsg.getText());
        }
        if (lastNameProvided==null){
            Assert.assertTrue(addEmployeePage.lastNameErrorMsg.isDisplayed());
            Assert.assertEquals(message, addEmployeePage.lastNameErrorMsg.getText());
        }

    }
}
