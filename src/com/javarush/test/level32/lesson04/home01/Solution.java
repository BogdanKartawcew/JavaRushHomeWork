package com.javarush.test.level32.lesson04.home01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Scanner;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\MyWORID\\Desktop\\test\\1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException { //сам рішив
        StringWriter writer = new StringWriter();
        try{
        Scanner s = new Scanner(is).useDelimiter("\\A");
        writer.write(s.hasNext() ? s.next() : "");}
        catch (Exception e)
        {
            writer.write("");
        }
        return writer;
    }
}
