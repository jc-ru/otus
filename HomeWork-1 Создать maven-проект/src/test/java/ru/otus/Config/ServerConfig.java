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

    @Key("db.name")
    @DefaultValue("selenium")
    String dbName();

    @Key("db.login")
    @DefaultValue("root")
    String dbLogin();

    @Key("db.password")
    @DefaultValue("")
    String dbPassword();

}
