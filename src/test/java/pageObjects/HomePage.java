package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JSutilities;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    JSutilities js = new JSutilities(driver);

    @FindBy(xpath = "//span[normalize-space()='My Account']") WebElement linkMyAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']") WebElement linkRegister;
    @FindBy(xpath = "//a[normalize-space()='Login']") WebElement linkLogin;
    @FindBy(xpath = "//input[@placeholder='Search']") WebElement txtSearchField;
    @FindBy(xpath = "//button[@class='btn btn-light btn-lg']") WebElement btnSearch;
    @FindBy(xpath = "//body/div[@id='container']/main/div[@id='product-search']/div[@class='row']/div[@id='content']/div[@id='product-list']/div[1]/div[1]/div[1]")
    WebElement productContainer;
    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria')]") WebElement txtProductNotFound;

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

    public void setTxtSearchField(String text){
        txtSearchField.sendKeys(text);
    }

    public void clickBtnSearch(){
        btnSearch.click();
    }

    public boolean isProductDisplayed(){
        js.scrollIntoView(productContainer);
        try {
            return productContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getProductNotFoundText(){
        js.scrollIntoView(txtProductNotFound);
        try {
            return txtProductNotFound.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
