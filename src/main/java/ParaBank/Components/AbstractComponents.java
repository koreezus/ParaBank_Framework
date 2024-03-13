package ParaBank.Components;

import ParaBank.Pages.*;
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
    @FindBy(css="a[href*='logout'")
    WebElement logoutBtn;
    @FindBy(css="a[href*='openaccount']")
    WebElement openAccountBtn;
    @FindBy(css="a[href*='overview']")
    WebElement accountOverviewBtn;
    @FindBy(xpath="//a[@href='admin.htm']")
    WebElement adminBtn;
    @FindBy(css="a[href*='index']")
    WebElement indexBtn;
    public void waitForElementAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean nameCheck(HashMap<String,String> data){
        ////make sure left-panel contains user's name
        waitForElementAppear(nameText);
        return nameText.getText().contains(data.get("firstName"));
    }
    //left-panel elements
    public NewAccountPage openAccount(){
        openAccountBtn.click();
        return new NewAccountPage(driver);
    }
    public IndexPage logoutApp(){
        logoutBtn.click();
        return new IndexPage(driver);
    }
    public IndexPage indexPage(){
        indexBtn.click();
        return new IndexPage(driver);
    }
    public OverviewPage accountOverview(){
        accountOverviewBtn.click();
        return new OverviewPage(driver);
    }
    public AdminPage adminPage(){
        //on first page load admin.htm has a jsession id attached to it? goes away on reload, making it hard to target element. fix later
        //waitForElementAppear(adminBtn);
        adminBtn.click();
        return new AdminPage(driver);
    }


}
