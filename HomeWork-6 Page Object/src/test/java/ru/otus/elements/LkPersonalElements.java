package ru.otus.elements;

public class LkPersonalElements {

    //Личный кабинет - "О себе"
    public static final String INPUT_FIRST_NAME = "//input[@name='fname']"; // инпут имя пользователя (xpath)
    public static final String INPUT_LAST_NAME = "//input[@name='lname']"; // инпут фамилии пользователя (xpath)
    public static final String INPUT_EU_FIRST_NAME = "//input[@name='fname_latin']"; // инпут имя пользователя на латинском (xpath)
    public static final String INPUT_EU_LAST_NAME = "//input[@name='lname_latin']"; // инпут фамилии пользователя на латинском (xpath)
    public static final String INPUT_BLOG_NAME = "//input[@name='blog_name']"; // инпут отображаемого имени пользователя в блоге (xpath)
    public static final String INPUT_DATE_BIRTH = "//input[@name='date_of_birth']"; // инпут ДР пользователя (xpath)
    public static final String INPUT_EMAIL = "//input[@name='email']"; // инпут Email пользователя (xpath)
    public static final String INPUT_PHONE = "//input[@name='phone']"; // инпут телефон пользователя (xpath)
    public static final String BTN_COMMUNICATION = "//div[contains(@class, 'lk-cv-block__input_md-4')]"; // кнопка "способ связи" (xpath)
    public static final String SUBMIT_PERSONAL_DATA = "//button[@title='Сохранить и продолжить']"; // кнопка "способ связи" (xpath)
    public static final String ADD_BTN_CONTACT_MESSENGER = "//button[contains(text(), 'Добавить')]"; // кнопка "Добавить" (xpath)
    public static final String NEW_INPUT_CONTACT_MESSENGER = "//input[@id='id_contact-1-value']"; // новый добавленный инпут (xpath)

}