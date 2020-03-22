package ru.otus.elements;

public class LkPersonalElements {

    //Личный кабинет - "О себе"
    public static final String INPUT_FIRST_NAME = "//input[contains(@name,'fname')]"; // инпут имя пользователя (xpath)
    public static final String INPUT_LAST_NAME = "//input[contains(@name,'lname')]"; // инпут фамилии пользователя (xpath)
    public static final String INPUT_EU_FIRST_NAME = "//input[contains(@name,'fname_latin')]"; // инпут имя пользователя на латинском (xpath)
    public static final String INPUT_EU_LAST_NAME = "//input[contains(@name,'lname_latin')]"; // инпут фамилии пользователя на латинском (xpath)
    public static final String INPUT_BLOG_NAME = "//input[contains(@name,'blog_name')]"; // инпут отображаемого имени пользователя в блоге (xpath)
    public static final String INPUT_DATE_BIRTH = "//input[contains(@name,'date_of_birth')]"; // инпут ДР пользователя (xpath)
    public static final String INPUT_EMAIL = "//input[contains(@name,'email')]"; // инпут Email пользователя (xpath)
    public static final String INPUT_PHONE = "//input[contains(@name,'phone')]"; // инпут телефон пользователя (xpath)
    public static final String BTN_COMMUNICATION = "//div[contains(@class, 'lk-cv-block__input_md-4')]"; // кнопка "способ связи" (xpath)
    public static final String SUBMIT_PERSONAL_DATA = "//button[contains(@title, 'Сохранить и продолжить')]"; // кнопка "способ связи" (xpath)
    public static final String ADD_BTN_CONTACT_MESSENGER = "//button[contains(text(), 'Добавить')]"; // кнопка "Добавить" (xpath)
    public static final String NEW_INPUT_CONTACT_MESSENGER = "//input[contains(@id, 'id_contact-1-value')]"; // новый добавленный инпут (xpath)

}