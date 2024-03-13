package ParaBank.TestCases;

import ParaBank.Pages.*;
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
        //create new account, verify username and name are correct, verify cash amount
        AdminPage admin = index.adminPage();
        admin.cleanDB();
        IndexPage index = admin.indexPage();
        RegistrationPage registration = index.clickRegistration();
        registration.submitRegistration(testData);
        Assert.assertTrue(registration.nameCheck(testData));
        Assert.assertTrue(registration.accountCheck(testData));
        OverviewPage overview = registration.accountOverview();
        Assert.assertTrue(overview.nameCheck(testData));
        System.out.println(overview.getAccountBalance());
        overview.logoutApp();

//        NewAccountPage accountPage = overview.openAccount();
//        accountPage.openCheckingAccount();
    }
    @Test(dataProvider="getData",dependsOnMethods = "newUserRegistration")
    public void positiveLogin(HashMap<String,String>testData){
        OverviewPage overview = index.loginAppPos(testData);
        Assert.assertTrue(overview.nameCheck(testData));
        overview.logoutApp();
    }
    @Test(dataProvider="getData")
    public void negativeLogin(HashMap<String,String>testData){
        Assert.assertEquals(index.loginAppNeg(testData),"An internal error has occurred and has been logged.");
    }
    @Test(dataProvider="getData",dependsOnMethods="newUserRegistration")
    public void passwordRecovery(HashMap<String,String>testData){
        LookupPage lookup = index.passwordRecovery();
        lookup.findLoginInfo(testData);
        //is there a better way instead of calling this twice?
        Assert.assertEquals(testData.get("username"), lookup.getLoginInfo().get(0));
        Assert.assertEquals(testData.get("password"),lookup.getLoginInfo().get(1));
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        DataReader dataReader = new DataReader();
        List<HashMap<String,String>>data=dataReader.mapJsonData(System.getProperty("user.dir")+"/src/test/java/ParaBank/TestData/NewUserData.json");
        return new Object[][]{{data.get(0)},{data.get(1)}};
    }
}
