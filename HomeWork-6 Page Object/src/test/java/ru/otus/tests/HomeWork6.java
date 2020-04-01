package ru.otus.tests;

import org.testng.annotations.Test;
import ru.otus.pages.LkPersonalPage;
import ru.otus.utils.DriversManager;
import ru.otus.utils.BaseTest;
import static ru.otus.config.ConfigProperties.*;


public class HomeWork6 extends BaseTest {

    LkPersonalPage lkPersonalPage;

    @Test
    public void homeWork6() {
        lkPersonalPage = new LkPersonalPage(driver, wait);
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
        DriversManager.deleteCookie();
        lkPersonalPage.open();
        loginPage.toAuth();
        lkPersonalPage
                .assertMessenger(0, MESSENGER_ONE_LINK)
                .assertMessenger(1, MESSENGER_TWO_LINK);
    }
}


