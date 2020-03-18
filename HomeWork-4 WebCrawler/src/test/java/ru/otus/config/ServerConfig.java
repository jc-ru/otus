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

    @Key("default.browser")
    @DefaultValue("firefox")
    String browserNameProperty();

    @Key("cars.crowler.url")
    @DefaultValue("https://www.drive2.ru/cars/mitsubishi/lancer_evolution/g1451/")
    String urlCrowlerCar();







}
