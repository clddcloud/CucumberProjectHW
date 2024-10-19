package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {
    @FindBy (id="personal_txtEmpFirstName")
    public WebElement firstNameField;

    @FindBy (id="personal_txtEmpLastName")
    public WebElement lastNameField;

    @FindBy (id="personal_txtEmployeeId")
    public WebElement idField;

    public PersonalDetailsPage(){
        PageFactory.initElements(driver, this);
    }

}
