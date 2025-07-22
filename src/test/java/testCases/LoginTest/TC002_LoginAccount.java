package testCases.LoginTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testCases.BaseTest;

public class TC002_LoginAccount extends BaseTest {
    @Test(dataProvider = "userCredentials")
    public void LoginTest(String email, String password){
        logger.info("---------- Started TC002_LoginAccount ----------");

        HomePage home = new HomePage(driver);
        home.clickLinkMyAccount();
        logger.info("Click link my account !");
        home.clickLinkLogin();
        logger.info("Click link login !");

        LoginPage login = new LoginPage(driver);
        logger.info("Providing account credentials !");
        login.setTxtEmail(email);
        login.setTxtPassword(password);
        login.clickBtnLogin();

        MyAccountPage account = new MyAccountPage(driver);
        boolean isMyAccountExist = account.isMyAccountPageExist();

        if(isMyAccountExist){
            Assert.assertTrue(true);
            account.clickBtnLogout();
            logger.info("Test Case Login Success Passed !");
        }else{
            if(login.isLoginFailed()){
                Assert.assertTrue(true);
                logger.info("Test Case Login Failed Passed !");
            }else{
                Assert.fail();
                logger.info("Test Case Failed !");
            }
        }

        logger.info("---------- Finished TC002_LoginAccount ----------");
    }

    @DataProvider(name = "userCredentials")
    public Object[][] loginData(){
        return new Object[][]{
                {property.getProperty("email"), property.getProperty("password")},
                {"test@gmail.com", "userpass"}
        };
    }
}

