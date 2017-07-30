package com.javarush.test.level34.lesson02.home01;

/**
 * Created by A261711 on 2017-07-14.
 */
class Pow implements Results
{

    private String create(String originalLine)
    {
        String start;
        String end;
        String before = originalLine.replace("(", "").replace(")", "").replaceAll("[A-Z]", "");
        {
            start = before.substring(0, before.indexOf("^"));
            end = before.substring(before.indexOf("^") + 1);
        }
        return String.valueOf(Math.pow(Double.parseDouble(start), Double.parseDouble(end)));
    }

    @Override// від інтерфейсу
    public String getResult(String line)
    {
        return create(line);
    }
}
