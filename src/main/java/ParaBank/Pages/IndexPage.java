package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class IndexPage extends AbstractComponents {

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "a[href*='register']")
    WebElement registrationBtn;
    @FindBy(css="input[value='Log In']")
    WebElement loginBtn;
    @FindBy(name="username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(className = "error")
    WebElement errorMsg;
    @FindBy(css="a[href*='lookup']")
    WebElement lookupBtn;
    public void getURL(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        waitForElementAppear(registrationBtn);
    }

    public RegistrationPage clickRegistration(){
        registrationBtn.click();

        return new RegistrationPage(driver);
    }
    public OverviewPage loginAppPos(HashMap<String,String>data){
        username.sendKeys(data.get("username"));
        password.sendKeys(data.get("password"));
        loginBtn.click();
        return new OverviewPage(driver);
    }
    public String loginAppNeg(HashMap<String,String>data){
        username.sendKeys(data.get("username"));
        password.sendKeys(data.get("wrongPassword"));
        loginBtn.click();
        return errorMsg.getText();
    }

    public LookupPage passwordRecovery(){
        lookupBtn.click();
        return new LookupPage(driver);
    }


}
