package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;
import com.javarush.test.level33.lesson15.big01.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by MyWORID on 12.06.2017.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    /*
    9.3.1.	Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов
    и иметь случайное имя. Подсказка: Files.createTempFile.
    9.3.2.	Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.
    9.3.3.	Обеспечивать удаление файла при выходе из программы. Подсказка: deleteOnExit().
    */
    {
        try
        {
            this.path = Files.createTempFile(Helper.generateRandomString(), null); // 1.
            path = Files.createTempFile("newFile", null); // 2.

        }
        catch (IOException e)
        {
            throw new ExceptionHandler();
        }
        path.toFile().deleteOnExit(); // 3.
    }

    public long getFileSize()
    /*он должен возвращать размер файла на который указывает path*/
    {
        try
        {
            return Files.size(path);
        }
        catch (IOException e)
        {
            return 0;
        }
    }

    public void putEntry(Entry entry)
    /*должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry*/
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(path.toFile(), true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entry);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException e)
        {
            throw new ExceptionHandler();
        }

    }

    public Entry getEntry()
    /*должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null*/
    {

        Entry entry = null;
        FileInputStream inputFileStream = null;
        ObjectInputStream objectInputStream = null;
        if (getFileSize()!=0)
        {
            try
            {
                inputFileStream = new FileInputStream(path.toFile());
                objectInputStream = new ObjectInputStream(inputFileStream);
                entry = (Entry) objectInputStream.readObject();
                objectInputStream.close();
                inputFileStream.close();
            }
            catch (IOException | ClassNotFoundException e)
            {
                throw new ExceptionHandler();
            }
        }
        return  entry;

    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            throw new ExceptionHandler();
        }
    }
}
