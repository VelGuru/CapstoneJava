package com.saucedemo.utills;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/testdata.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
