package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    static Random random = new Random();

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream resultPassword = new ByteArrayOutputStream();
        String result = "";
        try
        {
            result += getRandomInt();
            result += getRandomLowerChar();
            result += getRandomUpperChar();
            result += getRandomLowerChar();
            result += getRandomInt();
            result += getRandomUpperChar();
            result += getRandomLowerChar();
            result += getRandomInt();

            /*for (int i = 1; i < 9; i++)
            {
                switch (random.nextInt(3))
                {
                    case 0:
                        result += getRandomInt();
                        break;
                    case 1:
                        result += getRandomLowerChar();
                        break;
                    default:
                        result += getRandomUpperChar();
                        break;
                }
            }*/

            byte[] array = result.getBytes();
            resultPassword.write(array);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return resultPassword;
    }

    private static int getRandomInt()
    {
        return random.nextInt(9);
    }

    private static Character getRandomLowerChar()
    {
        return (char) (random.nextInt(26) + 'a');
    }

    private static Character getRandomUpperChar()
    {
        return (char) (random.nextInt(26) + 'A');
    }
}
