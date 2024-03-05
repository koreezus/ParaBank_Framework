package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class RegistrationPage extends AbstractComponents {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="input[value='Register']")
    WebElement registerBtn;
    @FindBy(id="customer.firstName")
    WebElement firstNameField;
    @FindBy(id="customer.lastName")
    WebElement lastNameField;
    @FindBy(id="customer.address.street")
    WebElement streetField;
    @FindBy(id="customer.address.city")
    WebElement cityField;
    @FindBy(id="customer.address.state")
    WebElement stateField;
    @FindBy(id="customer.address.zipCode")
    WebElement zipField;
    @FindBy(id="customer.phoneNumber")
    WebElement phoneNumField;
    @FindBy(id="customer.ssn")
    WebElement ssnField;
    @FindBy(id="customer.username")
    WebElement userNameField;
    @FindBy(id="customer.password")
    WebElement passwordField;
    @FindBy(id="repeatedPassword")
    WebElement repeatedPassword;
    @FindBy(className="title")
    WebElement userNameText;

    public void submitRegistration(HashMap<String, String> data){
        waitForElementAppear(registerBtn);
        firstNameField.sendKeys(data.get("firstName"));
        lastNameField.sendKeys(data.get("lastName"));
        cityField.sendKeys(data.get("addressCity"));
        streetField.sendKeys(data.get("addressStreet"));
        stateField.sendKeys(data.get("addressState"));
        zipField.sendKeys(data.get("addressZip"));
        phoneNumField.sendKeys(data.get("phoneNumber"));
        ssnField.sendKeys(data.get("ssn"));
        userNameField.sendKeys(data.get("username"));
        passwordField.sendKeys(data.get("password"));
        repeatedPassword.sendKeys(data.get("password"));
        registerBtn.click();
    }

    public boolean accountCheck(HashMap<String,String>data){
        // make sure new account contains correct username
        waitForElementAppear(userNameText);
        return userNameText.getText().contains(data.get("username"));
    }
}
