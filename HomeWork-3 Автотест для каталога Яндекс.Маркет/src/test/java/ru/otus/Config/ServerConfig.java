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
    int testsWaitingTime();

    @Key("tests.implicitly.waiting.time")
    @DefaultValue("4")
    int testsImplicitlyWaitingTime();




}
