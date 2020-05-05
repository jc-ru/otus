package ru.otus.steps.main;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.utils.DriversManager;

import static ru.otus.config.UrlAndPath.SYSTEM_URL;

public class MainSteps {
    public static WebDriver driver = DriversManager.getDriver();
    public static WebDriverWait wait = DriversManager.getDriverWait();

    @Given("Open main Habr page")
    @Step("Открыть ресурс")
    public static void getUrl() {
        driver.get(SYSTEM_URL);
    }

}
