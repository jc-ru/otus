package ru.otus.elements;

public class LoginElements {
    public static final String TITTLE_LOGIN_PAGE  = "//span[contains(text(), 'Войдите в свой аккаунт')]";
    public static final String INPUT_LOGIN  = "//form[contains(@class,'new-log-reg__form')]/div/input[@name='email']";
    public static final String INPUT_PASSWORD  = "//form[contains(@class,'new-log-reg__form')]/div/input[contains(@name,'password')]";
    public static final String SUBMIT_LOGIN_PAGE  = "//form[contains(@class,'new-log-reg__form')]/div/button[@type='submit']";
    public static final String TITTLE_LK_PAGE  = "//h1[contains(@class, 'title__text') and contains(text(), 'Личный кабинет')]";
}
