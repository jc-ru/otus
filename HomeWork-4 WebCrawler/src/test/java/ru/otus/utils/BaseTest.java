package ru.otus.utils;

import com.opencsv.CSVWriter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.*;


public class BaseTest {

    final public static Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public CSVWriter writeCsv;


    @BeforeSuite
    public void setupSuite() {
        driver = DriversManager.getDriver();
        wait = DriversManager.getDriverWait();
    }

    @BeforeMethod
    public void setupTest() throws IOException {
        logger.info("Start test");
        CSVUtils.closeCsvWriter();
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
