package ru.otus.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class BaseConfigurationTest {

    final private static Logger logger = LogManager.getLogger(BaseConfigurationTest.class);
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    public void setupSuite() {
        driver = DriversManager.getDriver();
        wait = DriversManager.getDriverWait();
    }

    @BeforeClass
    public void setupClass() {

    }

    @BeforeMethod
    public void setupTest() {
    }

    @AfterMethod
    public void TestFailure(ITestResult result) {
        if (! result.isSuccess()) {
            AttachmentFiles.attachScreenshot();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        DriversManager.stopAllDrivers();
    }

}
