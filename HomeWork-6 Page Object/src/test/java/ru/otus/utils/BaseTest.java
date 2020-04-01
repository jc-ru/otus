package ru.otus.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.otus.pages.LoginPage;


public class BaseTest {

    final public static Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver = DriversManager.getDriver();
    public WebDriverWait wait = DriversManager.getDriverWait();
    public LoginPage loginPage;

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
