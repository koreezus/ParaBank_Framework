package ParaBank.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver){
        this.driver=driver;
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
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
}
