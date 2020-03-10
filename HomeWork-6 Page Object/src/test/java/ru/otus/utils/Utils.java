package ru.otus.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.otus.config.ServerConfig;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;


public class Utils {

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(Utils.class);
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeClass
    public void setupClass() {
        logger.info("Driver initialization");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.operadriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        String browserParameter = getParameter();
        String browserName = browserParameter.toLowerCase();
        logger.info("Start browser: " + browserName);

        switch (browserName) {
            case "chrome":
                driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
                break;
            case  "firefox":
                driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
                break;
            case "ie":
                driver = WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions());
                break;
            case "opera":
                driver = WebDriverPool.DEFAULT.getDriver(new OperaOptions());
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(cfg.testsImplicitlyWaitingTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, cfg.testsWaitingTime());
    }

    @AfterMethod
    public void teardown() {
        if (driver !=null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }


    private String getParameter() {
        String value = System.getProperty("browser");
        if (value == null) {
            return "chrome";
        } else if (value.isEmpty()) {
            return "chrome";
        } else {
            return value;
        }
    }
}
