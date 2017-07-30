package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main (String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("Перше й!звідси... аж!00 а345ж досі3455!й а це все вже не підходить."));
        System.out.println(getPartOfString("тут очень мало"));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string==null) throw new TooShortStringException(); //поки це не добавив - задача не проходила
        String result = "";
        String str[] = string.split(" ");
        try
        {
            for (int i = 0; i < string.length(); i++)
            {
                if (i > 0 && i <= 3)
                    result +=str[i] + " ";
                if (i == 4)
                    result +=str[i];
            }
        }catch (Exception e)
        {throw new TooShortStringException();}
        return result;
    }

    public static class TooShortStringException extends Exception{
    }
}
