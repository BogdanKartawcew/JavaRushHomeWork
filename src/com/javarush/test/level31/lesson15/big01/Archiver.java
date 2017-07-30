package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by MyWORID on 06.06.2017.
 */
public class Archiver
{
    public static void main (String [] args) throws IOException
    {
        System.out.println("Введіть, будь ласка, повну адресу файла-архіва. Наприклад: \"C:\\Users\\MyWORID\\Desktop\\test\\test.zip\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path pathZip = Paths.get(reader.readLine());
        ZipFileManager zipFileManager = new ZipFileManager(pathZip);
        //System.out.println(pathZip);
        System.out.println("Введіть, будь ласка, повний шлях до файлу, який порібно архівувати");
        Path pathFile = Paths.get(reader.readLine());
        try
        {
            zipFileManager.createZip(pathFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
