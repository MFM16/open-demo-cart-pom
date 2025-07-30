package testCases.SearchTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testCases.BaseTest;

public class SearchNotFound extends BaseTest {

    @Test
    public void searchTest(){
        logger.info("----- Test SearchNotFound Started -----");

        HomePage homePage = new HomePage(driver);
        homePage.setTxtSearchField("Testing Search");
        homePage.clickBtnSearch();

        String notFound = homePage.getProductNotFoundText();

        if (notFound.equals("There is no product that matches the search criteria.")){
            logger.info("Test Case Succeed");
            Assert.assertTrue(true);
        } else {
            logger.info("Test Case Failed");
            Assert.fail();
        }

        logger.info("----- Test SearchNotFound Finished -----");
    }
}
