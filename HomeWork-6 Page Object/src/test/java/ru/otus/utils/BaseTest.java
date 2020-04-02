package ru.otus.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.otus.pages.LoginPage;


public class BaseTest {

    final public static Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;

    @BeforeSuite
    public void setupSuite() {
        driver = DriversManager.getDriver();
        wait = DriversManager.getDriverWait();
    }

    @BeforeClass
    public void setupClass() {
        loginPage = new LoginPage(driver, wait);
    }

    @BeforeMethod
    public void setupTest() {
        logger.info("Start test");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Finish test");
    }

    @AfterSuite
    public void tearDownSuite() {
        DriversManager.stopAllDrivers();
    }

}
