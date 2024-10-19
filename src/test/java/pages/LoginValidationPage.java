package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginValidationPage extends CommonMethods {
    @FindBy(name="txtUsername")
    public WebElement userNameField;

    @FindBy(name="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy (id="spanMessage")
    public WebElement errorMessage;

    @FindBy (id="welcome")
    public WebElement welcomeMessage;

    public LoginValidationPage(){
         PageFactory.initElements(driver, this);
    }

}
