package testCases.RegistrationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testCases.BaseTest;

public class TC001_AccountRegistration extends BaseTest {
    @Test
    public void verifyAccountRegistration(){
        logger.info("---------- Test TC001_AccountRegistration ----------");

        HomePage home = new HomePage(driver);
        home.clickLinkMyAccount();
        logger.info("Click link my account !");
        home.clickLinkRegister();
        logger.info("Click link register !");

        RegistrationPage regis = new RegistrationPage(driver);
        logger.info("Providing information details !");
        regis.setTxtFirstName(randomAlphabet());
        regis.setTxtLastName(randomAlphabet());
        regis.setTxtEmail(randomAlphabet()+"@gmail.com");
        regis.setTxtPassword(randomAlphaNumeric());
        regis.clickCheckboxAgreement();
        regis.clickBtnContinue();

        String confirmationMsg = regis.getConfirmationMessage();
        if (confirmationMsg.equals("Your Account Has Been Created!")){
            Assert.assertTrue(true);
            logger.info("Test Case Success !");
        } else {
            Assert.fail();
            logger.info("Test Case Failed !");
        }

        logger.info("---------- Finished TC001_AccountRegistration ----------");
    }
}
