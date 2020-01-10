package ru.otus.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.otus.Grafana.ExecutionListener;
import ru.otus.Presets.Presets;
import org.testng.annotations.*;

import java.lang.*;

import static ru.otus.Config.Config.*;
import static ru.otus.Elements.Elements.*;

@Listeners(ExecutionListener.class)
public class Lesson2 extends Presets {

    final private Logger logger = Logger.getLogger(Lesson2.class);

    @Test
    public void homeWork1() {
        try {
            logger.debug("Инициализация запуска сайта " + SYSTEM_URL);
            driver.get(SYSTEM_URL);
            logger.debug("Ожидание на странице, элемента " + HOME_LOGO);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HOME_LOGO)));
            try {
                Assert.assertEquals(TITLE_SYSTEM, driver.getTitle());
                logger.info("Страница " + SYSTEM_URL + " открыта, title совпадает");
            } catch (AssertionError e) {
                logger.error(e + " Message: Искомый title не найден");
                Assert.fail("Искомый title не найден");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            Assert.fail(e.getMessage());
        }
    }

    //Тесты для кол-ва, для Grafana
    @Test
    public void homeWork1_1() throws InterruptedException {
        Assert.fail();

    }

    @Test
    public void homeWork1_2() {
        Assert.fail();
    }


}
