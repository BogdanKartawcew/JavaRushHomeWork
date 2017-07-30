package com.javarush.test.level34.lesson02.home01;

import java.util.Objects;

/**
 * Created by MyWORID on 17.07.2017.
 */
public class CountCalc implements Results
{

    public int getCount(String line)
    {
        int count = 0;

        //рахуємо кількість тригонометричних функцій
        String[] valueArray = line.split("[\\W\\d]");
        for (String s : valueArray) if (!Objects.equals(s, "")) count++;

        //рахуємо решту
        String[] temporaryValue = line.split("");
        for (String s : temporaryValue)
            if (s.equals("-") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("^")) count++;
        return count;
    }

    @Override// від інтерфейсу
    public String getResult(String line)
    {
        return String.valueOf(getCount(line));
    }
}
