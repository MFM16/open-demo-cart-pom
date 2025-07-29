package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testCases.JSutilities;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='My Account']") WebElement myAccountHeader;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnLogout;

    public boolean isMyAccountPageExist(){
        try {
            return myAccountHeader.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickBtnLogout(){
        JSutilities js = new JSutilities(driver);
        js.scrollIntoView(btnLogout);
        js.click(btnLogout);
    }
}
