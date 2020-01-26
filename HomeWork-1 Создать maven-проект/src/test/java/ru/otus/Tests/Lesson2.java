package ru.otus.Tests;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.otus.Config.ServerConfig;
import ru.otus.Grafana.ExecutionListener;
import ru.otus.Presets.Presets;
import org.testng.annotations.*;

import java.lang.*;

import static ru.otus.Config.ServerConfig.*;
import static ru.otus.Elements.Elements.*;

@Listeners(ExecutionListener.class)
public class Lesson2 extends Presets {
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(Lesson2.class);

    @Test
    @Parameters()
    public void homeWork1() {
            driver.get(cfg.systemUrl());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(HOME_LOGO)));
            try {
                Assert.assertEquals(TITLE_SYSTEM, driver.getTitle());
            } catch (AssertionError e) {
                logger.error(e);
                Assert.fail();
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
