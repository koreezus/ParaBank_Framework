package ParaBank.TestComponents;

import ParaBank.Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver initializeApp() throws IOException {
        WebDriver driver;
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
    return driver;
    }
    @BeforeMethod
    public IndexPage initDriver() throws IOException {
        WebDriver driver = initializeApp();
        IndexPage indexPage = new IndexPage(driver);
        indexPage.getURL();
        return indexPage;
    }
}
