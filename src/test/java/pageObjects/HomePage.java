package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testCases.JSutilities;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    JSutilities js = new JSutilities(driver);

    @FindBy(xpath = "//span[normalize-space()='My Account']") WebElement linkMyAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']") WebElement linkRegister;
    @FindBy(xpath = "//a[normalize-space()='Login']") WebElement linkLogin;

    public void clickLinkMyAccount(){
        js.scrollIntoView(linkMyAccount);
        js.click(linkMyAccount);
    }

    public void clickLinkLogin(){
        js.scrollIntoView(linkLogin);
        js.click(linkLogin);
    }

    public void clickLinkRegister(){
        linkRegister.click();
    }
}
