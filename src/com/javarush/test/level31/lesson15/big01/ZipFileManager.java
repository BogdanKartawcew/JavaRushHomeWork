package com.javarush.test.level31.lesson15.big01;

import java.nio.file.Path;

/**
 * Created by MyWORID on 06.06.2017.
 */
public class ZipFileManager
{
    private Path zipFile; //полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception //Path source – это путь к чему-то, что мы будем архивировать
    {

    }
}
