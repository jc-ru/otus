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

    @Key("username")
    @DefaultValue("Test")
    String userName();

    @Key("password")
    @DefaultValue("Test")
    String password();

}
