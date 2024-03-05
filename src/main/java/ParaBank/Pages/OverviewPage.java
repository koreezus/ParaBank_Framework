package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends AbstractComponents {
    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="b.ng-binding")
    WebElement totalCell;
    public String getAccountBalance(){
        return totalCell.getText();
    }

}
