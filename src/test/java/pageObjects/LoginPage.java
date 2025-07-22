package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']") WebElement btnLogin;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertLoginFailed;

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public boolean isLoginFailed(){
        try{
            return alertLoginFailed.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
