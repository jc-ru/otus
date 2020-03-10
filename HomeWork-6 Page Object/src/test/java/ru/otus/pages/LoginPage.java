package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static ru.otus.elements.ConfigProperties.*;
import static ru.otus.elements.LoginElements.*;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    // Авторизация на страницы логина
    public LoginPage toAuth() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITTLE_LOGIN_PAGE)));
        driver.findElement(By.xpath(INPUT_LOGIN)).clear();
        driver.findElement(By.xpath(INPUT_LOGIN)).sendKeys(LOGIN);
        driver.findElement(By.xpath(INPUT_PASSWORD)).clear();
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(SUBMIT_LOGIN_PAGE)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITTLE_LK_PAGE)));
        PageFactory.initElements(driver, this);
        return this;
    }


}
