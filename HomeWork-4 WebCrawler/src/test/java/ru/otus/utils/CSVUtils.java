package ru.otus.utils;

import com.opencsv.CSVWriter;

import java.io.*;

public class CSVUtils {
    public static CSVWriter writeCsv;


    public static CSVWriter getCsvWriter(String[] titlesCsv) throws FileNotFoundException, UnsupportedEncodingException {

        writeCsv = new CSVWriter(
                new OutputStreamWriter(new FileOutputStream("reports/report-cars.csv"),
                        "cp1251"), ';', '"', '"', "\n");
        writeCsv.writeNext(titlesCsv);

        return writeCsv;
    }

    public static void closeCsvWriter() throws IOException {
        if (writeCsv != null) {
            writeCsv.close();
        }
    }

}
