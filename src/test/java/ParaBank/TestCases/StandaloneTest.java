package ParaBank.TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StandaloneTest {
    public static void main(String[] args) {
        //STANDALONE TEST THAT RUNS THROUGH ACCOUNT CREATION AND CHECKING ACCOUNT CREATION
        //driver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-application-cache");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //wait for an element
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[type='submit']"))));

        //click registration link
        driver.findElement(By.cssSelector("a[href*='register']")).click();
        //standalone test for username: testaccount password: testingpassword
        //could change to css*= containing text
        driver.findElement(By.id("customer.firstName")).sendKeys("kor");
        driver.findElement(By.id("customer.lastName")).sendKeys("hen");
        driver.findElement(By.id("customer.address.street")).sendKeys("address1");
        driver.findElement(By.id("customer.address.city")).sendKeys("city1");
        driver.findElement(By.id("customer.address.state")).sendKeys("state1");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("11111");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("testaccount");
        driver.findElement(By.id("customer.password")).sendKeys("testingpassword");
        driver.findElement(By.id("repeatedPassword")).sendKeys("testingpassword");
        driver.findElement(By.cssSelector("input[value='Register']")).click();

        //assert welcome message appears
        Assert.assertEquals(driver.findElement(By.className("title")).getText(),"Welcome testaccount");
        //make sure left-panel contains user's name
        Assert.assertTrue(driver.findElement(By.className("smallText")).getText().contains("kor hen"));

        //open new checking account
        driver.findElement(By.cssSelector("a[href*='openaccount']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value*='Account']"))));
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByIndex(0);
        driver.findElement(By.cssSelector("input[value*='Account']")).click();
        //open new savings account


        //shutdown application
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[href*='admin']"))));
        driver.findElement(By.cssSelector("a[href='admin.htm']")).click();
        //wait for element to appear
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[value='CLEAN']"))));
        //reset database
        driver.findElement(By.cssSelector("button[value='CLEAN']")).click();
        //close application
        driver.quit();

        //ACCOUNTS OVERVIEW has weird bugs
        //open new checking account, verify account creation
        //verify account number
        //verify account balance is $50

        //verify total is still $300

    }
}
