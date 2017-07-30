package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        /*if (string == null) {
            throw new TooShortStringException();
        }
        int i = string.indexOf('\t');
        int j =  string.indexOf('\t',i+1);
        String  tmp = string.substring(i + 1,j);
        if (i == -1 || j == -1) throw new TooShortStringException();
        return tmp;*/

        String result;
        try {
            if (string==null){throw new TooShortStringException();}
            else {
                int tab1 = string.indexOf("\t");
                int tab2 = string.indexOf("\t", tab1 + 1);
                result = string.substring(tab1+1, tab2);
            }
        }catch (Exception e){throw new TooShortStringException();}
        return result;


        /*if (string == null) throw new TooShortStringException();
        String result = "";
        String str[] = string.split("\t");
        int count = 0;

            for (int i = 0; i < string.length(); i++)
            {
                if(string.charAt(i) == '\t')
                    count++;
            }
        if (str[1].isEmpty()) str[1] +=str[1]+"";
        System.out.println("str = "+str[1]);
        System.out.println(count);
        if (count>1)
        result +=str[1];
        else throw new TooShortStringException();
        return result;*/


    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {

        System.out.println(getPartOfString("tab0\ttabre\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("\tr\t"));                    //
        System.out.println(getPartOfString(null));                      //Exception
        System.out.println(getPartOfString("r123\tre123"));                //Exception
        System.out.println(getPartOfString("dfgdgdgdfgdfgdgfg"));
    }
}
