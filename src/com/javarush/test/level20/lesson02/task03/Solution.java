package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void main(String[] args) throws Exception {
        fillInPropertiesMap();
    }

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        InputStream inputStream = new FileInputStream(filename);
        load(inputStream);
        OutputStream outputStream = new FileOutputStream(filename);
        save(outputStream);
        outputStream.flush();

        outputStream.close();
        inputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> entry : prop.entrySet())
        {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for(Map.Entry<String,String> entry : properties.entrySet())
        {
            prop.put(entry.getKey(),entry.getValue());
        }
        prop.store(outputStream,"");
    }
}
