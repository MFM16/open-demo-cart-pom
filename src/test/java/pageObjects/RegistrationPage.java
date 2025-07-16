package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastName;
    @FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
    @FindBy(xpath = "//input[@name='agree']") WebElement checkboxAgreement;
    @FindBy(xpath = "//button[normalize-space()='Continue']") WebElement btnContinue;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmationMessage;

    public void setTxtFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }

    public void setTxtLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickCheckboxAgreement(){
        checkboxAgreement.click();
    }

    public void clickBtnContinue(){
        btnContinue.click();
    }

    public String getConfirmationMessage(){
        try {
            return confirmationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
