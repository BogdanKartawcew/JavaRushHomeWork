package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by MyWORID on 04.06.2017.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    /*Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.*/
    {
        if(file.getName().toLowerCase().endsWith(".html") || file.getName().toLowerCase().endsWith(".htm"))
            return true;
        else if (file.isDirectory())
            return true;
        else
        return false;
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
