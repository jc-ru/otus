package ru.otus.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
//    public static void main(String[] args)
//            throws Exception {
//        FileInputStream propFile =
//                new FileInputStream( "src/test/resources/config.properties");
//        Properties p =
//                new Properties(System.getProperties());
//        p.load(propFile);
//        System.setProperties(p);
//
//
//    }



//    public static final String SYSTEM_URL = System.getProperty("url.system", "http://ya.ru"); // URL тестируемой системы
//    public static final String TESTS_WAITING_TIME = System.getProperty("tests.waiting.time", "10"); // URL тестируемой системы
//    public static final String DB_HOST = System.getProperty("db.host", "http://localhost:8086"); // URL тестируемой системы
//    public static final String DB_LOGIN = System.getProperty("db.login", "root"); // URL тестируемой системы
//    public static final String DB_PASSWORD = System.getProperty("db.password", "root"); // URL тестируемой системы


    public static final String SYSTEM_URL = "http://otus.ru"; // URL тестируемой системы
    public static final String TESTS_WAITING_TIME = "10"; // Единое время ожидания элементов для всех автотестов (в секундах)
    public static final String DB_HOST = "http://185.219.43.85:8086"; // URL БД
    public static final String DB_LOGIN = "otus"; // Логин БД
    public static final String DB_PASSWORD = "54321"; // Пароль БД
}
