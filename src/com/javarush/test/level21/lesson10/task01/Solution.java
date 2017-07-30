package com.javarush.test.level21.lesson10.task01;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* Рефакторинг
Отрефакторите метод writeZipEntriesToFile в соответствии с java7 try-with-resources.
Допускаются только текстовые коментарии.
*/
public class Solution {

    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) throws IOException
    {
        Path path = Paths.get(outputFileName);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(String.valueOf(path)),"UTF-8"));
             ZipFile zip = new ZipFile(zipFileName))
        {
            String newLine = System.getProperty("line.separator");
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {

                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
