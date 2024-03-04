package ParaBank.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class AbstractComponents {
    public WebDriver driver;
    WebDriverWait wait;
    public AbstractComponents(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(3L));
        PageFactory.initElements(driver,this);
    }
    @FindBy(className="smallText")
    WebElement nameText;
    public void waitForElementAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementDissapear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForByAppear(){

    }
    public void waitForByDissapear(){

    }
    public boolean nameCheck(HashMap<String,String> data){
        ////make sure left-panel contains user's name
        waitForElementAppear(nameText);
        return nameText.getText().contains(data.get("firstName"));
    }
}
