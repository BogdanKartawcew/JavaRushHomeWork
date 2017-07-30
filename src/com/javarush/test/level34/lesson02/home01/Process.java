package com.javarush.test.level34.lesson02.home01;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by A261711 on 2017-07-14.
 */

public class Process implements Results
{

    private String refact(String line)
    {
        return process(line.replaceAll(",", ".").replaceAll(" ", "").toUpperCase());
    }


    private String process(String string)
    {
        String originalLine = string;

        /*посилаємось на скрипт JS, якщо у виразі є тільки прості дії ( * + - / )*/
        if (!originalLine.contains("SIN") && !originalLine.contains("COS") && !originalLine.contains("TAN") && !originalLine.contains("CTG") && !originalLine.contains("^"))
        {
            Decouple decouple = new Decouple();
            originalLine = originalLine.replace(originalLine, decouple.getResult(originalLine));
        }
        while (originalLine.contains("("))//шукаємо дужки
        {
            String line = originalLine.substring(originalLine.lastIndexOf("(") + 1);
            String opened = line.substring(0, line.indexOf(")"));
            originalLine = algorithm(new String[]{opened, originalLine});
        }

        while (!isDouble(originalLine))
        { // шукаємо коли дужок вже нема
            String opened = originalLine;
            originalLine = algorithm(new String[]{opened, originalLine});
        }
        return replacing(originalLine);
    }


    private String algorithm(String[] array)
    {
        String originalLine = array[1];
        String opened = array[0];
        if (originalLine.contains("--"))
            originalLine = originalLine.replace("--", "+"); // якщо доходить до двох мінусів підряд - міняємо знак

        else if (opened.contains("^"))
        { //шукаємо степені. навіть якщо їх там кілька - ми шукаємо в методі їх по одному
            String[] voidResult = findPows(opened);
            originalLine = originalLine.replace(voidResult[0], voidResult[1]);
        } else if (opened.contains("SIN") || opened.contains("COS") || opened.contains("TAN") || opened.contains("CTG"))
        {
            String[] replaceFromTo = findTrigonometricFunction(opened); //0 - from, 1 - to
            originalLine = originalLine.replace(replaceFromTo[0], replaceFromTo[1]);
        } else if (isDouble(opened) && Double.parseDouble(opened) < 0)
            originalLine = originalLine.replace("(" + opened + ")", opened);

        else if (isDouble(opened) && !opened.contains("-"))
            originalLine = originalLine.replace("(" + opened + ")", opened);


        else if (!opened.contains("SIN") && !opened.contains("COS") && !opened.contains("TAN") && !opened.contains("CTG") && !opened.contains("^"))
        {
            Decouple decouple = new Decouple();
            originalLine = originalLine.replace(opened, decouple.getResult(opened));
        }

        return originalLine;
    }


    private String replacing(String line)
    {
        return String.valueOf(new DecimalFormat("#.##").format(Double.parseDouble(line))).replace(",", ".");
    }


    private String[] findTrigonometricFunction(String originalLine)
    {
        String value = null;
        String[] valueArray = originalLine.split("[A-Z]"); //залишає все крім букв
        List<String> valueList = new LinkedList<>(Arrays.asList(valueArray));
        Collections.reverse(valueList);
        for (String a : valueList)
        {
            if (!a.equals("")) value = a;
            break;
        }
        String[] temporaryValue = value.split("[*/+-]");

        //якщо трапляється тригонометрична функція з відємним числом
        if (originalLine.contains("SIN-") || originalLine.contains("COS-") || originalLine.contains("TAN-") || originalLine.contains("CTG-"))
            value = "-" + temporaryValue[1];
        else
            value = temporaryValue[0];

        String math = null;
        String[] mathArray = originalLine.split("[\\W\\d]"); //залишає тільки букви
        List<String> mathList = new LinkedList<>(Arrays.asList(mathArray));
        Collections.reverse(mathList);
        for (String a : mathList)
        {
            if (!a.equals("")) math = a;
            break;
        }
        return new String[]{math + value, resultTrigonometricFunction(math, value)};
    }


    private String resultTrigonometricFunction(String math, String value)
    {
        double result = 0.0;
        double integer = Math.toRadians(Double.parseDouble(value));
        if (math.equals("SIN")) result = Math.sin(integer);
        if (math.equals("COS")) result = Math.cos(integer);
        if (math.equals("TAN")) result = Math.tan(integer);
        if (math.equals("CTG")) result = Math.cos(integer) / Math.sin(integer);
        return replacing(String.valueOf(result));
    }


    private String[] findPows(String string)
    {
        String from = string;
        String to;
        String[] openedArray = from.split("[*/+-]");

        //якщо трапляється степінь з відємним числом
        if (string.contains("^-"))
        {
            for (String anOpenedArray : openedArray)
                if (anOpenedArray.contains("^-")) from = anOpenedArray;

        } else
        {
            for (String anOpenedArray : openedArray)
                if (anOpenedArray.contains("^")) from = anOpenedArray;

        }

        int count = countOfPows(from); //рахуємо кількість степенів у виразі...
        if (count == 1)
        {
            Pow pow = new Pow();
            to = pow.getResult(from);
        } else
        { //...і обрізаємо до одного, якщо їх більше
            String[] array = from.split("[\\^]");
            from = array[array.length - 2] + "^" + array[array.length - 1];
            Pow pow = new Pow();
            to = pow.getResult(from.replaceAll("[A-Z]", ""));
        }
        return new String[]{from.replaceAll("[A-Z]", ""), to};
    }


    private int countOfPows(String line)
    {
        int count = 0;
        char[] array = line.toCharArray();
        for (char anArray : array)
            if (anArray == '^') count++;
        return count;
    }


    public boolean isDouble(String value)
    {// публічний для того щоб мати доступ до нього з іншпих класів
        try
        {
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    @Override //від інтерфейсу
    public String getResult(String line)
    {
        return refact(line);
    }
}
