package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Logger logger;
    public Properties property;
    public WebDriverWait wait;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String browser) throws IOException {
        FileReader file = new FileReader("./src/test/resources/config.properties");
        property = new Properties();
        property.load(file);

        logger = LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()){
            case "chrome" :
                driver = new ChromeDriver();
                logger.info("Testing in Chrome Browser");
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                logger.info("Testing in Firefox Browser");
                break;
            case "edge" :
                driver = new EdgeDriver();
                logger.info("Testing in Edge Browser");
                break;
            default:
                System.out.println("Invalid browser");
                return;
        }


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(property.getProperty("app" +
                "Url"));
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
