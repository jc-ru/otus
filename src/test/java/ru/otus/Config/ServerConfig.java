package ru.otus.Config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {

    @Key("url.system")
    @DefaultValue("http://test.com")
    String systemUrl();

    @Key("tests.waiting.time")
    @DefaultValue("10")
    String testsWaitingTime();

    @Key("db.host")
    @DefaultValue("http://localhost:8080")
    String dbHost();

    @Key("db.login")
    @DefaultValue("root")
    String dbLogin();

    @Key("db.password")
    @DefaultValue("")
    String dbPassword();




//    public static final String SYSTEM_URL = "http://otus.ru"; // URL тестируемой системы
//    public static final String TESTS_WAITING_TIME = "10"; // Единое время ожидания элементов для всех автотестов (в секундах)
//    public static final String DB_HOST = "http://185.219.43.85:8086"; // URL БД
//    public static final String DB_LOGIN = "otus"; // Логин БД
//    public static final String DB_PASSWORD = "54321"; // Пароль БД
}
