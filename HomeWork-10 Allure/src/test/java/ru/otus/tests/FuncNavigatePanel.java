package ru.otus.tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.otus.descriptions.DescNavigatePanel;
import ru.otus.steps.main.MainSteps;
import ru.otus.steps.main.NavigatePanelSteps;
import ru.otus.utils.AttachmentFiles;
import ru.otus.utils.BaseConfigurationTest;

import static ru.otus.config.UrlAndPath.*;
import static ru.otus.steps.FuncNavigatePanelSteps.*;

@Epic("Habr - Не авторизованная зона")
@Feature("Функционал навигационной панели")
@Owner("S.Konovalov")
public class FuncNavigatePanel extends BaseConfigurationTest {
    final private static Logger logger = LogManager.getLogger(FuncNavigatePanel.class);

    @Story("Смена языка интерфейса")
    @Description(DescNavigatePanel.changeInterfaceLang)
    @Severity(SeverityLevel.NORMAL)
    @Test
    void changeInterfaceLang() {
            MainSteps.getUrl(SYSTEM_URL);
            saveTitlePage();
            NavigatePanelSteps.editLangBtn();
            clickRatioBtnEng();
            saveLangSettings();
            checkChangeLangToEng();
            NavigatePanelSteps.editLangBtn();
            clickRatioBtnRus();
            saveLangSettings();
            checkChangeLangToRus();
    }

    @Story("Кнопка входа в систему")
    @Description(DescNavigatePanel.checkLoginBtn)
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void checkLoginBtn() {
            MainSteps.getUrl(SYSTEM_URL);
            NavigatePanelSteps.loginBtn();
            checkAuthPage();
    }

    @Story("Кнопка регистрации в системе")
    @Description(DescNavigatePanel.checkRegBtn)
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void checkRegBtn() {
            MainSteps.getUrl(SYSTEM_URL);
            NavigatePanelSteps.regBtn();
            checkRegPage();
    }
}