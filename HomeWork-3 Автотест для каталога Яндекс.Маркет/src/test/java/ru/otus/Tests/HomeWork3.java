package ru.otus.Tests;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.otus.Config.ServerConfig;
import ru.otus.Presets.Presets;

import java.util.List;

import static ru.otus.Elements.Elements.*;


public class HomeWork3 extends Presets {
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(ru.otus.Tests.HomeWork3.class);



    @Test
    public void homeWork3() {
        String item1 = "Honor"; // Брэнд товара 1
        String item2 = "Xiaomi"; // Брэнд товара 2

        try {
            //получаем куки с ya.ru
            driver.get("https://ya.ru/");
            Cookie cookie1 = driver.manage().getCookieNamed("yandex_gid");
            Cookie cookie2 = driver.manage().getCookieNamed("yandexuid");

            //переходим в маркет
            driver.get(cfg.systemUrl());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BTN_MENU)));
            driver.manage().addCookie(new Cookie("yandex_gid", cookie1.getValue()));
            driver.manage().addCookie(new Cookie("yandexuid", cookie2.getValue()));

            // Открываем меню
            driver.findElement(By.xpath(BTN_MENU)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WRAP_MENU)));

            //Наводим на раздел "Электроника"
            WebElement menuHover = driver.findElement(By.xpath(BTN_MENU_ELECTRON));
            Actions action = new Actions(driver);
            action.moveToElement(menuHover).build().perform();

            //Кликаем в категорию "Мобильные телефоны"
            driver.findElement(By.xpath(BTN_HREF_MOB_TEL)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_H1_MOB_PAGE)));

            //ставим фильтры цены
            driver.findElement(By.xpath(FILTER_PRICE)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));
            //ставим фильтры по смартфонам
            driver.findElement(By.xpath(FILTER_SMARTPHONE)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));

            //находим первый товар
            driver.findElement(By.xpath(FILTER_SHOW_ALL)).click();
            driver.findElement(By.xpath(FILTER_INPUT_MODEL)).clear();
            driver.findElement(By.xpath(FILTER_INPUT_MODEL)).sendKeys(item1);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '"+ item1 + "')]")));
            driver.findElement(By.xpath("//span[contains(text(), '" + item1 + "')]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));
            //находим 2-ой товар
            driver.findElement(By.xpath(FILTER_INPUT_MODEL)).clear();
            driver.findElement(By.xpath(FILTER_INPUT_MODEL)).sendKeys(item2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '" + item2 + "')]")));
            driver.findElement(By.xpath("//span[contains(text(), '" + item2 + "')]")).click();
            ((JavascriptExecutor)driver).executeScript("scroll(0,0)");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));

            //Добавляем в сравнение 1-ый товар
            driver.findElement(By.xpath(TITLE_ITEM + item1 + "')]]" + BTN_ADD_SIMILE)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INFORMER_SIMILE)));
            //Проверка всплывающего информера
            try {
                driver.findElement(By.xpath(INFORMER_SIMILE));
                driver.findElement(By.xpath(TITLE_INFORMER_SIMILE + item1 + "')]"));
            } catch (Exception e) {
                logger.error(e);
                Assert.fail("Всплывающий информер о добавлении товара в сравнения - отсутствует");
            }

            //Добавляем в сравнение 2-ой товар
            driver.findElement(By.xpath(TITLE_ITEM + item2 + "')]]" + BTN_ADD_SIMILE)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INFORMER_SIMILE)));
            //Проверка всплывающего информера
            try {
                driver.findElement(By.xpath(INFORMER_SIMILE));
                driver.findElement(By.xpath(TITLE_INFORMER_SIMILE + item2 + "')]"));
            } catch (Exception e) {
                logger.error(e);
                Assert.fail("Всплывающий информер о добавлении товара в сравнения - отсутствует");
            }

            //Переход на страницу сравнения товаров
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_INFORMER_SIMILE_END_ANIMATION)));
            driver.findElement(By.xpath(BTN_SIMILE)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_H1_SIMILE_PAGE)));
            //Проверка на кол-во товаров в списке сравнений
            List<WebElement> itemsList = driver.findElements(By.xpath(ITEM_SIMILE));
            if (itemsList.size() == 2) {
            } else {
                Assert.fail("Ожидается 2 товара в списке сравнений, по факту " + itemsList.size());
            }
            //Открытие вкладки "все характеристики"
            driver.findElement(By.xpath(BTN_ALL_CHAR)).click();
            //ожидание исчезновения прелоадера
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));
            //проверка на присутствие параметра "Операционная система"
            try {
                driver.findElement(By.xpath(OS_PARAM_CHAR));
                Assert.fail("Параметр 'Операционная система' отсутствует в разделе 'все характеристики'");
            } catch (Exception ignored) {
                logger.info("Параметр 'Операционная система' присутствует в разделе 'все характеристики'");
            }
            //Открытие вкладки "различающиеся характеристики"
            driver.findElement(By.xpath(BTN_DIFF_CHAR)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRELOAD)));
            //проверка на отсутствие параметра "Операционная система"
            try {
                driver.findElement(By.xpath(OS_PARAM_CHAR));
                logger.info("Параметр 'Операционная система' отсутствует в разделе 'различающиеся характеристики'");
            } catch (Exception e) {
                logger.error(e);
                Assert.fail("Параметр 'Операционная система' присутствует в разделе 'различающиеся характеристики'");
            }
        } catch (Exception e) {
            logger.error(e);
            Assert.fail(e.getMessage());
        }
    }
}


