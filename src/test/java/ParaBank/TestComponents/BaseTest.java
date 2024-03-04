package ParaBank.TestComponents;

import ParaBank.Pages.IndexPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    //remember scope of driver and index!

    public IndexPage index;
    WebDriver driver;
    public void initializeApp() throws IOException {
        //properties object to read .property file
        Properties prop = new Properties();
        //load file
        FileReader fileReader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/GlobalData.properties");
        prop.load(fileReader);
        String browser = prop.getProperty("browser");
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new SafariDriver();
        }
    }
    @BeforeMethod(alwaysRun = true)
    public IndexPage initDriver() throws IOException {
        initializeApp();
        index = new IndexPage(driver);
        index.getURL();
        return index;
    }
//    @AfterTest(alwaysRun=true)
//    public void tearDown(){
//        driver.quit();
//    }
}
