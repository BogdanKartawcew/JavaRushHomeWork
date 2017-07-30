package com.javarush.test.level05.lesson12.home04;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM y");
        System.out.println(dateFormat.format( new Date() ) );
}
}
