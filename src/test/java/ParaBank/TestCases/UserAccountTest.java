package ParaBank.TestCases;

import ParaBank.Pages.IndexPage;
import ParaBank.Pages.RegistrationPage;
import ParaBank.TestComponents.BaseTest;
import ParaBank.TestData.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UserAccountTest extends BaseTest {
    @Test(dataProvider="getData")
    public void newUserRegistration(HashMap<String,String>testData) throws IOException {
        RegistrationPage registration = index.clickRegistration();
        registration.submitRegistration(testData);
        Assert.assertTrue(registration.nameCheck(testData));
        Assert.assertTrue(registration.accountCheck(testData));
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        DataReader dataReader = new DataReader();
        List<HashMap<String,String>>data=dataReader.mapJsonData(System.getProperty("user.dir")+"/src/test/java/ParaBank/TestData/NewUserData.json");
        return new Object[][]{{data.get(0)},{data.get(1)}};
    }
}
