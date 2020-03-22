package ru.otus.config;

import org.aeonbits.owner.ConfigFactory;
import ru.otus.config.ServerConfig;

public class ConfigProperties {
    static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public static final String LOGIN = cfg.lkUserName(); // Логин входа в систему
    public static final String PASSWORD = cfg.lkPassword(); // Пароль входа в систему
    public static final String FIRST_NAME = cfg.firstname(); // Имя пользователя
    public static final String LAST_NAME = cfg.lastname(); // Фамилия пользователя
    public static final String EU_FIRST_NAME = cfg.euFirstName(); // Имя пользователя на латинском
    public static final String EU_LAST_NAME = cfg.euLastName(); // Фамилия пользователя на латинском
    public static final String BLOG_NAME = cfg.blogName(); // Имя пользователя для отображения в блоге
    public static final String DATE_BIRTH = cfg.dateBirth(); // Дата рождения пользователя
    public static final String EMAIL = cfg.contactEmail(); // Email пользователя
    public static final String PHONE = cfg.contactPhone(); // Телефон пользователя
    public static final String MESSENGER_ONE = cfg.contactMessengerOne(); // Мессенджер пользователя №1
    public static final String MESSENGER_TWO = cfg.contactMessengerTwo(); // Мессенджер пользователя №2
    public static final String MESSENGER_ONE_LINK = cfg.contactMessengerOneLink(); // Линк на мессенджер №1
    public static final String MESSENGER_TWO_LINK = cfg.contactMessengerTwoLink(); // Линк на мессенджер №2

}
