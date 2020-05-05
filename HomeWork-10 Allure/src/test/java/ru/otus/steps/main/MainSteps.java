package ru.otus.steps.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.utils.DriversManager;

public class MainSteps {
    public static WebDriver driver = DriversManager.getDriver();
    public static WebDriverWait wait = DriversManager.getDriverWait();

    @Step("Открыть ресурс {url}")
    public static void getUrl(String url) {
        driver.get(url);
    }

}
