package testCases.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testCases.BaseTest;

public class TC002_LoginAccount extends BaseTest {
    @Test
    public void LoginTest(){
        logger.info("---------- Started TC002_LoginAccount ----------");

        HomePage home = new HomePage(driver);
        home.clickLinkMyAccount();
        logger.info("Click link my account !");
        home.clickLinkLogin();
        logger.info("Click link login !");

        LoginPage login = new LoginPage(driver);
        logger.info("Providing account credentials !");
        login.setTxtEmail(property.getProperty("email"));
        login.setTxtPassword(property.getProperty("password"));
        login.clickBtnLogin();

        MyAccountPage account = new MyAccountPage(driver);
        boolean isMyAccountExist = account.isMyAccountPageExist();

        if(isMyAccountExist){
            Assert.assertTrue(true);
            logger.info("Test Case Passed !");
        }else{
            Assert.fail();
            logger.info("Test Case Failed !");
        }

        logger.info("---------- Finished TC002_LoginAccount ----------");
    }
}
