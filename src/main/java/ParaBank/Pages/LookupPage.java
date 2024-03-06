package ParaBank.Pages;

import ParaBank.Components.AbstractComponents;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LookupPage extends AbstractComponents {
    public LookupPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="firstName")
    WebElement firstNameField;
    @FindBy(id="lastName")
    WebElement lastNameField;
    @FindBy(id="address.street")
    WebElement streetField;
    @FindBy(id="address.city")
    WebElement cityField;
    @FindBy(id="address.state")
    WebElement stateField;
    @FindBy(id="address.zipCode")
    WebElement zipcodeField;
    @FindBy(id="ssn")
    WebElement ssnField;
    @FindBy(css="input[value*='Login Info']")
    WebElement submitBtn;
    @FindBy(xpath = "//div[@id='rightPanel']/p[1]")
    WebElement lookupText;
    @FindBy(xpath="//div[@id='rightPanel']/p[2]")
    WebElement foundCredentials;
    public void findLoginInfo(HashMap<String,String> data){
        firstNameField.sendKeys(data.get("firstName"));
        lastNameField.sendKeys(data.get("lastName"));
        streetField.sendKeys(data.get("addressStreet"));
        cityField.sendKeys(data.get("addressCity"));
        stateField.sendKeys(data.get("addressState"));
        zipcodeField.sendKeys(data.get("addressZip"));
        ssnField.sendKeys(data.get("ssn"));
        submitBtn.click();
    }
    public List<String> getLoginInfo(){
        //grab whole chunk of text
        String fullText=foundCredentials.getText();
        //separate text by ':' and throw into a list
        List<String>credentialList=new ArrayList<>();
        Collections.addAll(credentialList,fullText.split(":")[1].trim(),fullText.split(":")[2].trim());
        return credentialList;
    }
}
