package ru.otus.Grafana;

import org.aeonbits.owner.ConfigFactory;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import ru.otus.Config.ServerConfig;

import static ru.otus.Config.ServerConfig.*;

public class ResultSender {
    private static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect(cfg.dbHost(), cfg.dbLogin(), cfg.dbPassword());
    private static final String DATABASE = "selenium";

    static{
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point){
        INFLXUDB.write(point);
    }

}
