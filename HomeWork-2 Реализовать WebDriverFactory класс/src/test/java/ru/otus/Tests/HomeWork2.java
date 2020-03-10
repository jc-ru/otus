package ru.otus.Tests;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.otus.Config.ServerConfig;
import ru.otus.Presets.Presets;
import ru.stqa.selenium.factory.WebDriverPool;

import static ru.otus.Elements.Elements.HOME_LOGO;
import static ru.otus.Elements.Elements.TITLE_SYSTEM;

public class HomeWork2 extends Presets {

    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(ru.otus.Tests.HomeWork2.class);

    @Test
    public void homeWork2() {
        driver.get(cfg.systemUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HOME_LOGO)));
        try {
            Assert.assertEquals(TITLE_SYSTEM, driver.getTitle());
        } catch (AssertionError e) {
            logger.error(e);
            Assert.fail();
        }
    }

    @Test
    public void homeWork2_2() {
        driver.get("https://ya.ru");
    }

    @Test
    public void homeWork2_3() {
        driver.get("https://google.ru");
    }

}
