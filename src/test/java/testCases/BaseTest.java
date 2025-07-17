package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    public void setup(){
        logger = LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/opencart/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomAlphabet(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumeric(){
        return RandomStringUtils.randomNumeric(12);
    }

    public String randomAlphaNumeric(){
        return (RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(12));
    }
}
