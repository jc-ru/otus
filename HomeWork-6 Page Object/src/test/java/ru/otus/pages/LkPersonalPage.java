package ru.otus.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.otus.tests.HomeWork6;

import java.util.List;
import static ru.otus.config.ConfigProperties.*;
import static ru.otus.elements.LkPersonalElements.*;
import static ru.otus.config.UrlAndPath.*;

public class LkPersonalPage {
    final private Logger logger = Logger.getLogger(HomeWork6.class);
    WebDriver driver;
    WebDriverWait wait;

    String emailVal;
    String phoneVal;

    @FindBy (xpath = INPUT_FIRST_NAME)
    private WebElement inputFirstName;

    @FindBy (xpath = INPUT_EU_FIRST_NAME)
    private WebElement inputEuFirstName;

    @FindBy (xpath = INPUT_LAST_NAME)
    private WebElement inputLastName;

    @FindBy (xpath = INPUT_EU_LAST_NAME)
    private WebElement inputEuLastName;

    @FindBy (xpath = INPUT_BLOG_NAME)
    private WebElement inputBlogName;

    @FindBy (xpath = INPUT_DATE_BIRTH)
    private WebElement inputDateBirth;

    @FindBy (xpath = INPUT_EMAIL)
    private WebElement inputEmail;

    @FindBy (xpath = INPUT_PHONE)
    private WebElement inputPhone;

    @FindBy (xpath = BTN_COMMUNICATION)
    private List<WebElement> btnCommunication;

    @FindBy (xpath = ADD_BTN_CONTACT_MESSENGER)
    private WebElement addBtnContactMessenger;


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
        inputFirstName.clear();
        inputFirstName.sendKeys(FIRST_NAME);
        inputEuFirstName.clear();
        inputEuFirstName.sendKeys(EU_FIRST_NAME);
        inputLastName.clear();
        inputLastName.sendKeys(LAST_NAME);
        inputEuLastName.clear();
        inputEuLastName.sendKeys(EU_LAST_NAME);
        inputBlogName.clear();
        inputBlogName.sendKeys(BLOG_NAME);
        inputDateBirth.clear();
        inputDateBirth.sendKeys(DATE_BIRTH);

        PageFactory.initElements(driver, this);
        return this;
    }


    // Изменения Email пользователя
    public LkPersonalPage setEmail() {
        emailVal = inputEmail.getAttribute("value");
        try {
            inputEmail.clear();
            inputEmail.sendKeys(EMAIL);
        } catch (Exception ex) {
            logger.info("Поле email содержит данные " + emailVal + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    // Изменения телефона пользователя
    public LkPersonalPage setPhone() {
        phoneVal = inputPhone.getAttribute("value");
        try {
            inputPhone.clear();
            inputPhone.sendKeys(PHONE);
        } catch (Exception ex) {
            logger.info("Поле телефон содержит данные " + phoneVal + " и оно не кликабельно");
        }
        PageFactory.initElements(driver, this);
        return this;
    }

    // Добавления нового контакта (мессенджера)
    public LkPersonalPage addMessenger(Integer nmbrMessenger, String nameMessenger, String linkMessenger) {
        List<WebElement> inputsMessengers = btnCommunication;
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
        addBtnContactMessenger.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_INPUT_CONTACT_MESSENGER)));

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
