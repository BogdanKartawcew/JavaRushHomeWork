package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
    public static void main(String[] args) throws Exception
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
int i = Integer.parseInt(s);

        int sum = Integer.parseInt(s);


        while (true)
        {
            String S = reader.readLine();
            if (S.equals("сумма")) break;
            sum = sum + Integer.parseInt(S);
        }
        System.out.print(sum);
    }
}
