package ru.otus.utils;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import ru.otus.config.ServerConfig;


public class BaseTest {

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(BaseTest.class);

    DriversManager driversManager;


    @BeforeClass
    public void setupClass() {
    }

    @BeforeMethod
    public void setupTest() {
    }

    @AfterMethod
    public void tearDown() {

    }

    @AfterSuite
    public void tearDownSuite() {
        driversManager.stopAllDrivers();
    }


//    private String getParameter() {
//        String value = System.getProperty("browser");
//        if (value == null) {
//            return "chrome";
//        } else if (value.isEmpty()) {
//            return "chrome";
//        } else {
//            return value;
//        }
//    }
}
