package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy (id="firstName")
    public WebElement firstNameField;

    @FindBy (id="middleName")
    public WebElement middleNameField;

    @FindBy (id="lastName")
    public WebElement lastNameField;

    @FindBy (id="employeeId")
    public WebElement employeeIdField;

    @FindBy (id="btnSave")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='message warning fadable']")
    public WebElement warningMsg;

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement firstNameErrorMsg;

    @FindBy(xpath = "//span[@for='lastName']")
    public WebElement lastNameErrorMsg;

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
