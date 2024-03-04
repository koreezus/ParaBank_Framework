package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends AbstractComponents {

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "a[href*='register']")
    WebElement registrationBtn;
    public void getURL(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        waitForElementAppear(registrationBtn);


    }

    public RegistrationPage clickRegistration(){
        registrationBtn.click();

        return new RegistrationPage(driver);
    }



}
