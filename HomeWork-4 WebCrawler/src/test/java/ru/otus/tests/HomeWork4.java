package ru.otus.tests;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.otus.config.ServerConfig;
import ru.otus.utils.BaseTest;


import java.util.ArrayList;
import java.util.List;


public class HomeWork4 extends BaseTest {
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(HomeWork4.class);


    @Test
    public void getReviewsCars() {

        driver.get(cfg.urlCrowlerCar());

        while (true) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 5000)");
            List<WebElement>  elementsCars = driver.findElements(By.cssSelector("a.u-link-area"));
            logger.debug("Count elements cars:  " + elementsCars.size());
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Показать ещё')]")));
            } catch (TimeoutException ex) {
                break;
            }
        }
        List<WebElement> elementsCars = driver.findElements(By.cssSelector("a.u-link-area"));
        logger.info("TOTAL: count elements cars  " + elementsCars.size());


        // Получение ссылки на авто
        ArrayList <String> urlsCars = new ArrayList<>();
        for (int counter = 0; counter < elementsCars.size(); counter++) {
            urlsCars.add(elementsCars.get(counter).getAttribute("href"));
            logger.info("Get url car " + (counter+1) + " of " + elementsCars.size());
            System.out.println("Value: " + urlsCars.get(counter));
        }
        logger.info("TOTAL: link cars " + urlsCars.size());

        // Получение инф. на авто и запись в CSV
        int counterNullReview = 0;
        int counterStatusSaled = 0;
        String title;
        String review;
        String statusSaled;

        for (int counter = 0; counter < elementsCars.size(); counter++) {
            title = "-";
            review = "-";
            statusSaled = "-";

            driver.get(urlsCars.get(counter));
            try {
                title = driver.findElement(By.xpath("//h1[@class='c-car-info__caption']")).getText();
            } catch (Exception ex) {
            }

            try {
                review = driver.findElement(By.xpath("//div[@itemprop='reviewBody']")).getText();
            } catch (Exception ex) {
                counterNullReview++;
            }
            try {
                driver.findElement(By.xpath("//div[@class='c-car-forsale']"));
                statusSaled = "ДА";
                counterStatusSaled++;
            } catch (Exception ex) {
            }

            //Запись данных в CSV
            writeCsv.writeNext(new String[]{title, review, statusSaled, urlsCars.get(counter)});

            logger.info("Checked auto  " + (counter+1) + " of " + elementsCars.size());
        }
        logger.info("Pages in which a review is left - " + counterNullReview);
        logger.info("Pages in which the car is for sale - " + counterStatusSaled);


    }

}
