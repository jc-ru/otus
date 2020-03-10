package ru.otus.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@Sources("classpath:config.properties")
public interface ServerConfig extends Config {


    @Key("tests.waiting.time")
    @DefaultValue("10")
    int testsWaitingTime();

    @Key("tests.implicitly.waiting.time")
    @DefaultValue("4")
    int testsImplicitlyWaitingTime();

    @Key("lk.username")
    @DefaultValue("Test")
    String lkUserName();

    @Key("lk.password")
    @DefaultValue("Test")
    String lkPassword();

    @Key("personal.firstname")
    @DefaultValue("Иван")
    String firstname();

    @Key("personal.lastname")
    @DefaultValue("Иванов")
    String lastname();

    @Key("personal.eu.firstname")
    @DefaultValue("Ivan")
    String euFirstName();

    @Key("personal.eu.lastname")
    @DefaultValue("Ivanov")
    String euLastName();

    @Key("personal.blogname")
    @DefaultValue("Ivan777")
    String blogName();

    @Key("personal.datebirth")
    @DefaultValue("10.10.2000")
    String dateBirth();

    @Key("personal.contacts.email")
    @DefaultValue("ex@ex.ru")
    String contactEmail();

    @Key("personal.contacts.phone")
    @DefaultValue("9000000000")
    String contactPhone();

    @Key("personal.contacts.messenger.one")
    @DefaultValue("VK")
    String contactMessengerOne();

    @Key("personal.contacts.messenger.two")
    @DefaultValue("Facebook")
    String contactMessengerTwo();

    @Key("personal.contacts.messenger.one.link")
    @DefaultValue("@bot1")
    String contactMessengerOneLink();

    @Key("personal.contacts.messenger.two.link")
    @DefaultValue("@bot2")
    String contactMessengerTwoLink();





}
