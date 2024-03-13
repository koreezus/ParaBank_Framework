package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends AbstractComponents {
    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="button[value='CLEAN']")
    WebElement cleanDBButton;
    public void cleanDB(){
        cleanDBButton.click();
    }
}
