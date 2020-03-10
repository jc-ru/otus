package ru.otus.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.otus.tests.HomeWork6;

import java.util.AbstractCollection;
import java.util.List;
import static ru.otus.elements.ConfigProperties.*;
import static ru.otus.elements.LkPersonalElements.*;
import static ru.otus.elements.UrlAndPath.*;

public class LkPersonalPage {
    final private Logger logger = Logger.getLogger(HomeWork6.class);
    WebDriver driver;
    WebDriverWait wait;

    String emailVal;
    String phoneVal;

    public LkPersonalPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Открытие страницы "О себе" в ЛК
    public LkPersonalPage open() {
        driver.get(URL_SYSTEM + PATH_PERSONAL_DATA);
        PageFactory.initElements(driver, this);
        return this;
    }


    // Изменения ФИО и ДР пользователя
    public LkPersonalPage editFullName() {
        driver.findElement(By.xpath(INPUT_FIRST_NAME)).clear();
        driver.findElement(By.xpath(INPUT_FIRST_NAME)).sendKeys(FIRST_NAME);
        driver.findElement(By.xpath(INPUT_EU_FIRST_NAME)).clear();
        driver.findElement(By.xpath(INPUT_EU_FIRST_NAME)).sendKeys(EU_FIRST_NAME);
        driver.findElement(By.xpath(INPUT_LAST_NAME)).clear();
        driver.findElement(By.xpath(INPUT_LAST_NAME)).sendKeys(LAST_NAME);
        driver.findElement(By.xpath(INPUT_EU_LAST_NAME)).clear();
        driver.findElement(By.xpath(INPUT_EU_LAST_NAME)).sendKeys(EU_LAST_NAME);
        driver.findElement(By.xpath(INPUT_BLOG_NAME)).clear();
        driver.findElement(By.xpath(INPUT_BLOG_NAME)).sendKeys(BLOG_NAME);
        driver.findElement(By.xpath(INPUT_DATE_BIRTH)).clear();
        driver.findElement(By.xpath(INPUT_DATE_BIRTH)).sendKeys(DATE_BIRTH);

        PageFactory.initElements(driver, this);
        return this;
    }


    // Изменения Email пользователя
    public LkPersonalPage setEmail() {
        emailVal = driver.findElement(By.xpath(INPUT_EMAIL)).getAttribute("value");
        try {
            driver.findElement(By.xpath(INPUT_EMAIL)).clear();
            driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        } catch (Exception ex) {
            logger.info("Поле email содержит данные " + emailVal + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    // Изменения телефона пользователя
    public LkPersonalPage setPhone() {
        phoneVal = driver.findElement(By.xpath(INPUT_PHONE)).getAttribute("value");
        try {
            driver.findElement(By.xpath(INPUT_PHONE)).clear();
            driver.findElement(By.xpath(INPUT_PHONE)).sendKeys(PHONE);
        } catch (Exception ex) {
            logger.info("Поле телефон содержит данные " + phoneVal + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    // Добавления нового контакта (мессенджера)
    public LkPersonalPage addMessenger(Integer nmbrMessenger, String nameMessenger, String linkMessenger) {
        List<WebElement> inputsMessengers = driver.findElements(By.xpath(BTN_COMMUNICATION));
        WebElement selectElement = inputsMessengers.get(nmbrMessenger);
        selectElement.click();

        List<WebElement> messengers = driver.findElements(By.xpath("//button[contains(@title, '" + nameMessenger + "')]"));
        WebElement selectMessenger = messengers.get(nmbrMessenger);
        selectMessenger.click();

        driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + nmbrMessenger + "-value')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + nmbrMessenger + "-value')]")).sendKeys(linkMessenger);

        PageFactory.initElements(driver, this);
        return this;
    }

    // Добавление нового поля для добавления нового контакта (мессенджера)
    public LkPersonalPage addBtnContactMessenger() {
        driver.findElement(By.xpath("//button[contains(text(), 'Добавить')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'id_contact-1-value')]")));

        PageFactory.initElements(driver, this);
        return this;
    }

    // Сохранение формы данных пользователя
    public LkPersonalPage submitPersonalForm() {
        driver.findElement(By.xpath(SUBMIT_PERSONAL_DATA)).click();

        PageFactory.initElements(driver, this);
        return this;
    }

    // Проверка на сохранение мессенджера
    public LkPersonalPage assertMessenger(Integer nmbrMessenger, String linkMessenger) {
        String inputValue = driver.findElement(By.xpath("//input[contains(@id, 'id_contact-" + nmbrMessenger + "-value')]")).getAttribute("value");
        try {
            Assert.assertEquals(inputValue, linkMessenger);
        } catch (AssertionError ex) {
            logger.info("Мессенджер с ссылкой" + linkMessenger + " не сохранился");
            Assert.fail(ex.getMessage());
        }

        PageFactory.initElements(driver, this);
        return this;
    }

}
