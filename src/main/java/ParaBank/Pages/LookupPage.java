package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class LookupPage extends AbstractComponents {
    public LookupPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void findLoginInfo(HashMap<String,String> data){
        System.out.println("do this later");
    }
}
