package ru.otus.elements;

public class NavigatePanel {

    /**Навигационная панель*/

    // Смена языка
    public static final String EDIT_LANG_BTN  = "//button[contains(@class, 'btn_navbar_lang')]"; // Кнопка смена языков
    public static final String RATIO_BTN_ENG  = "//label[@for='hl_langs_en']"; // Радио-баттон смена языка интерфейса на Английский
    public static final String RATIO_BTN_RUS  = "//label[@for='hl_langs_ru']"; // Радио-баттон смена языка интерфейса на Русский

    // Вход
    public static final String LOG_IN_BTN  = "login"; // Кнопка входа в систему (id)
    public static final String TITLE_LOGIN_PAGE  = "//div[contains(@class, 'shadow-box__title') and contains(text(), 'Вход')]"; // Заголовок на странице авторизации

    // Регистрация
    public static final String REG_BTN  = "//a[contains(@class, 'btn_navbar_registration')]"; // Кнопка регистрации в системе
    public static final String TITLE_REG_PAGE  = "//div[contains(@class, 'shadow-box__title') and contains(text(), 'Регистрация')]"; // Заголовок на странице регистрации

}
