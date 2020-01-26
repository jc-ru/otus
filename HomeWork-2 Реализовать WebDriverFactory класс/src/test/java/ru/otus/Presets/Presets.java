package ru.otus.Presets;

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
import ru.otus.Config.ServerConfig;
import ru.stqa.selenium.factory.WebDriverPool;



public class Presets {
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(Presets.class);
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

        if(browserName.equals("chrome")) {
            driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
        } else if(browserName.equals("firefox")) {
            driver = WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
        } else if(browserName.equals("ie")) {
            driver = WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions());
        } else if(browserName.equals("opera")) {
            driver = WebDriverPool.DEFAULT.getDriver(new OperaOptions());
        } else {
            driver = WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
        }


        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Integer.parseInt(cfg.testsWaitingTime()));
    }

    @AfterMethod
    public void teardown() {

    }

    @AfterSuite
    public void stopAllDrivers() {
        WebDriverPool.DEFAULT.dismissAll();
    }


    private String getParameter() {
        String value = System.getProperty("browser");
        if (value == null)
            throw new RuntimeException("browser" + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException("browser" + " is empty!");

        return value;
    }
}
