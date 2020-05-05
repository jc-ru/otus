package ru.otus.steps;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.otus.utils.AttachmentFiles;
import ru.otus.utils.DriversManager;

import static ru.otus.elements.MainElements.*;
import static ru.otus.elements.NavigatePanel.*;

public class FuncNavigatePanelSteps {
    final private static Logger logger = LogManager.getLogger(FuncNavigatePanelSteps.class);
    private static WebDriver driver = DriversManager.getDriver();
    private static WebDriverWait wait = DriversManager.getDriverWait();

    private static String ruHeaderText;
    private static String euHeaderText;

    @Step("Смена языка интерфейса на английский")
    public static void clickRatioBtnEng() {
        driver.findElement(By.xpath(RATIO_BTN_ENG)).click();
    }

    @Step("Смена языка интерфейса на русский")
    public static void clickRatioBtnRus() {
        driver.findElement(By.xpath(RATIO_BTN_RUS)).click();
    }

    @Step("Сохранение языковых настроек")
    public static void saveLangSettings() {
        driver.findElement(By.xpath(SUBMIT_BTN)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SUBMIT_BTN)));
    }

    @Step("Сохранение заголовка страницы")
    public static void saveTitlePage() {
        ruHeaderText = driver.findElement(By.xpath(TITLE_SECTION)).getText();
    }

    @Step("Проверка изменения языка с русского на английский")
    public static void checkChangeLangToEng() {
        try {
            euHeaderText = driver.findElement(By.xpath(TITLE_SECTION)).getText();
            Assert.assertNotEquals(euHeaderText, ruHeaderText);
        } catch (AssertionError ex) {
            AttachmentFiles.attachScreenshot();
            logger.error("Заголовок до смены языка: {}, заголовок после смены языка {}", ruHeaderText, euHeaderText);
            Assert.fail("Смена языка интерфейса не произошла");
        }
    }

    @Step("Проверка изменения языка с английского на русский")
    public static void checkChangeLangToRus() {
        try {
            ruHeaderText = driver.findElement(By.xpath(TITLE_SECTION)).getText();
            Assert.assertNotEquals(ruHeaderText, euHeaderText);
        } catch (AssertionError ex) {
            AttachmentFiles.attachScreenshot();
            logger.error("Заголовок до смены языка: {}, заголовок после смены языка {}", euHeaderText, ruHeaderText);
            Assert.fail("Смена языка интерфейса не произошла");
        }
    }

    @Step("Проверка открытия страницы авторизации")
    public static void checkAuthPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_LOGIN_PAGE)));
        } catch (TimeoutException ex) {
            AttachmentFiles.attachScreenshot();
            logger.error(ex);
            Assert.fail("Страница авторизации не обнаружена");
        }
    }

    @Step("Проверка открытия страницы регистрации")
    public static void checkRegPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_REG_PAGE)));
        } catch (TimeoutException ex) {
            AttachmentFiles.attachScreenshot();
            logger.error(ex);
            Assert.fail("Страница регистрации не обнаружена");
        }
    }
}
