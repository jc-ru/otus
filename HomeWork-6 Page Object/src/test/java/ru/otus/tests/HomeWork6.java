package ru.otus.tests;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.otus.config.ServerConfig;
import ru.otus.pages.LkPersonalPage;
import ru.otus.pages.LoginPage;
import ru.otus.utils.DriversManager;
import ru.otus.utils.BaseTest;
import static ru.otus.config.ConfigProperties.*;


public class HomeWork6 extends BaseTest {
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    final private Logger logger = Logger.getLogger(HomeWork6.class);

    LoginPage loginPage;
    LkPersonalPage lkPersonalPage;
    DriversManager driversManager;


    @Test
    public void homeWork6() {
        lkPersonalPage = new LkPersonalPage(driversManager.getDriver(), driversManager.getDriverWait());
        loginPage = new LoginPage(driversManager.getDriver(), driversManager.getDriverWait());
        lkPersonalPage.open();
        loginPage.toAuth();
        lkPersonalPage
                .editFullName()
                .setEmail()
                .setPhone()
                .addMessenger(0, MESSENGER_ONE, MESSENGER_ONE_LINK)
                .addBtnContactMessenger()
                .addMessenger(1, MESSENGER_TWO, MESSENGER_TWO_LINK)
                .submitPersonalForm();
//        driver.manage().deleteAllCookies();

        lkPersonalPage = new LkPersonalPage(driversManager.getDriver(), driversManager.getDriverWait());
        loginPage = new LoginPage(driversManager.getDriver(), driversManager.getDriverWait());
        lkPersonalPage.open();
        loginPage.toAuth();
        lkPersonalPage
                .assertMessenger(0, MESSENGER_ONE_LINK)
                .assertMessenger(1, MESSENGER_TWO_LINK);
    }
}


