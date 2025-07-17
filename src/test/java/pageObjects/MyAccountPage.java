package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='My Account']") WebElement myAccountHeader;

    public boolean isMyAccountPageExist(){
        try {
            return myAccountHeader.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
