package ru.otus.Grafana;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import static ru.otus.Config.Config.*;

public class ResultSender {

    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect(DB_HOST, DB_LOGIN, DB_PASSWORD);
    private static final String DATABASE = "selenium";

    static{
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point){
        INFLXUDB.write(point);
    }

}
