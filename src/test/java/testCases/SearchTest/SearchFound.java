package testCases.SearchTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testCases.BaseTest;

public class SearchFound extends BaseTest {

    @Test
    public void searchTest(){
        logger.info("----- Test SearchFound Started -----");

        HomePage homePage = new HomePage(driver);
        homePage.setTxtSearchField("MAC");
        homePage.clickBtnSearch();

        if (homePage.isProductDisplayed()){
            logger.info("Test Case Succeed");
            Assert.assertTrue(true);
        } else {
            logger.info("Test Case Failed");
            Assert.fail();
        }

        logger.info("----- Test SearchFound Finished -----");
    }
}
