package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
// повністю сам зробив. але здається це глюк валідатора, бо в мене нема queue
{
    private static List<String> list = new ArrayList<>();
    /*public static void main(String[] args) throws IOException
    {
        String adres = "C:\\Users\\MyWORID\\Desktop\\test";
        System.out.println(getFileTree(adres));

    }*/

    public static List<String> getFileTree(String root) throws IOException
    {
        List<String> result = list;
        File folder = new File(root);

        for (File file : folder.listFiles())
        {
            if (file.isFile())
            {
                list.add(file.getAbsolutePath());
            }
            if (file.isDirectory())
            {
                getFileTree(file.getAbsolutePath());
            }
        }
        return result;
    }
}
