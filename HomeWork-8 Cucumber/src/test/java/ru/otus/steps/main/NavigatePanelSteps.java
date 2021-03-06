package ru.otus.steps.main;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.utils.DriversManager;

import static ru.otus.elements.NavigatePanel.*;

public class NavigatePanelSteps {
    public static WebDriver driver = DriversManager.getDriver();
    public static WebDriverWait wait = DriversManager.getDriverWait();

    @And("Click LanguageChange button")
    @Step("Клик по кнопке смены языка")
    public static void editLangBtn() {
        driver.findElement(By.xpath(EDIT_LANG_BTN)).click();
    }

    @When("Click Login button")
    @Step("Клик по кнопке \"Вход\"")
    public static void loginBtn() {
        driver.findElement(By.id(LOG_IN_BTN)).click();
    }

    @When("Click Registration button")
    @Step("Клик по кнопке \"Регистрация\"")
    public static void regBtn() {
        driver.findElement(By.xpath(REG_BTN)).click();
    }

}
