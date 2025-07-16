package testCases.RegistrationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testCases.BaseTest;

public class TC001_AccountRegistration extends BaseTest {
    @Test
    public void verifyAccountRegistration(){
        HomePage home = new HomePage(driver);
        home.clickLinkMyAccount();
        home.clickLinkRegister();

        RegistrationPage regis = new RegistrationPage(driver);
        regis.setTxtFirstName(randomAlphabet());
        regis.setTxtLastName(randomAlphabet());
        regis.setTxtEmail(randomAlphabet()+"@gmail.com");
        regis.setTxtPassword(randomAlphaNumeric());
        regis.clickCheckboxAgreement();
        regis.clickBtnContinue();

        String confirmationMsg = regis.getConfirmationMessage();
        Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
    }
}
