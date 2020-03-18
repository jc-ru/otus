package ru.otus.utils;

import com.opencsv.CSVWriter;
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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected CSVWriter writeCsv;

    @BeforeSuite
    public void setupSuite() throws IOException {
        FileOutputStream csvWrite = new FileOutputStream("reports/report-cars.csv");
        csvWrite.write(0xef);
        csvWrite.write(0xbb);
        csvWrite.write(0xbf);
        writeCsv = new CSVWriter(new OutputStreamWriter(csvWrite), ';');
        writeCsv.writeNext(new String[]{"Название", "Отзыв", "Статус продажи", "Ссылка"});
    }


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
        driver.manage().timeouts().implicitlyWait(cfg.testsImplicitlyWaitingTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, cfg.testsWaitingTime());
    }

    @AfterMethod
    public void teardown() {

    }

    @AfterSuite
    public void stopAllDrivers() throws IOException {
        WebDriverPool.DEFAULT.dismissAll();
        if (writeCsv != null) {
            writeCsv.close();
        }
    }


    private String getParameter() {
        String value = System.getProperty("browser");
        if (value == null) {
            return cfg.browserNameProperty();
        } else if (value.isEmpty()) {
            return cfg.browserNameProperty();
        } else {
            return value;
        }
    }

}
