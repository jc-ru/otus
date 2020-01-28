package ru.otus.Elements;

public class Elements {

    //main
    public static final String PRELOAD = "//div[contains(@class, 'preloadable__preloader_visibility_visible')]"; // прелоадер (xpath)

    //Главная
    public static final String BTN_MENU = "//button[contains(@id, '27903768-tab')]"; // Кнопка "Меню" (xpath)
    public static final String WRAP_MENU = "//div[contains(@class, '_3XkkZLVQDG')]"; // wrapper меню (xpath)
    public static final String BTN_MENU_ELECTRON = "//button[contains(@id, '39889744-tab')]/a/span[contains(text(), 'Электроника')]"; // Кнопка "Электроника в раскрывающемся меню (xpath)
    public static final String BTN_HREF_MOB_TEL = "//a[contains(text(), 'Мобильные телефоны')]"; // ссылка с текстом "Мобильные телефоны (xpath)

    //Раздел "Мобильные телефоны"
    public static final String TITLE_H1_MOB_PAGE = "//h1[contains(@class,'title_changeable_yes') and contains(text(), 'Мобильные телефоны')]"; // Заголовок страницы "Мобильные телефоны" (xpath)
    public static final String BTN_ADD_SIMILE = "/div/div/div/div[contains(@class, 'n-user-lists_type_compare_in-list_no')]"; // Кнопка добавления товара в сравнения (xpath)
    public static final String BTN_SIMILE = "//a[contains(@class,'button_theme_action')]"; // Кнопка "сравнить" на всплывающем информере при добавлении товара в сравнения (xpath)
    public static final String INFORMER_SIMILE = "//div[contains(@class,'popup-informer')]"; // Всплывающий информер при добавлении товара в сравнения (xpath)
    public static final String TITLE_ITEM = "//div[./a[contains(@title, '"; // Заголовок товара (xpath)
    public static final String TITLE_INFORMER_SIMILE = "//div[contains(@class,'popup-informer__title') and contains(text(), '"; // Заголовок Всплывающего информера при добавлении товара в сравнения (xpath)
    public static final String TITLE_INFORMER_SIMILE_END_ANIMATION = "//div[contains(@class,'popup-informer_js_inited') and contains(@style, 'top: 0px; opacity: 1;')]"; // Всплывающий информер при добавлении товара в сравнения c завершеной анимацией появления (xpath)

    //Фильтры
    public static final String FILTER_PRICE = "//a[contains(text(), 'по цене')]"; // фильтр по цене (xpath)
    public static final String FILTER_SMARTPHONE = "//label/div/span[contains(text(), 'смартфон')]"; // фильтр смартфон (xpath)
    public static final String FILTER_SHOW_ALL = "//button[contains(text(), 'Показать всё')]"; // фильтр "Показать всё" (xpath)
    public static final String FILTER_INPUT_MODEL = "//input[contains(@id, '7893318-suggester')]"; // фильтр инпут ввода модели (xpath)

    //Страница сравнения товаров
    public static final String TITLE_H1_SIMILE_PAGE = "//h1[contains(@class,'title') and contains(text(), 'Сравнение товаров')]"; // Заголовок Н1 на странице сравнения товаров (xpath)
    public static final String ITEM_SIMILE = "//div[contains(@class, 'n-compare-cell-draggable')]"; // Товар на странице сравнения товаров (xpath)
    public static final String BTN_ALL_CHAR = "//span[contains(@class, 'link__inner') and contains(text(), 'все характеристики')]"; // Кнопка "Все характеристики" (xpath)
    public static final String BTN_DIFF_CHAR = "//span[contains(@class, 'link__inner') and contains(text(), 'различающиеся характеристики')]"; // Кнопка "Различающиеся характеристики" (xpath)
    public static final String OS_PARAM_CHAR = "//div[contains(@class, 'n-compare-row_hidden_yes')]/div/div[contains(@class, 'n-compare-row-name') and contains(text(), 'Операционная система')]"; // Параметр "Операционная система" в характеристиках (xpath)

}