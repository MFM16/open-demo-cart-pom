package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSutilities {
    public WebDriver driver;

    public JSutilities(WebDriver driver){
        this.driver = driver;
    }

    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
}
