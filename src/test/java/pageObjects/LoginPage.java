package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSutilities;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    JSutilities js = new JSutilities(driver);

    @FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']") WebElement btnLogin;
    @FindBy(xpath = "//button[@class='btn-close']") WebElement btnCloseAlert;

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public boolean isButtonLoginDisplayed(){
        try {
            return btnLogin.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

}
