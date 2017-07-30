package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution
{
    // мої спроби
    /*public static void main(String[] args)
    {
        Number number1 = new Number(NumerationSystemType._10, "123456");
        Number s1 = convertNumberToOtherNumerationSystem(number1, NumerationSystemType._8);
        System.out.println(s1); //0361100

        Number number2 = new Number(NumerationSystemType._10, "22");
        Number s2 = convertNumberToOtherNumerationSystem(number2, NumerationSystemType._2);
        System.out.println(s2);    //expected 0b10110

        Number number8 = new Number(NumerationSystemType._8, "012");
        Number s8 = convertNumberToOtherNumerationSystem(number8, NumerationSystemType._10);
        System.out.println(s8); //10

        Number number16 = new Number(NumerationSystemType._8, "06");
        Number s16 = convertNumberToOtherNumerationSystem(number16, NumerationSystemType._16);
        System.out.println(s16); //0x6

        Number number15 = new Number(NumerationSystemType._7, "db999sdf2");
        Number s15 = convertNumberToOtherNumerationSystem(number16, NumerationSystemType._16);
        System.out.println(s16); //0x6

    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem)
    {
        int oldType = number.getNumerationSystem().getNumerationSystemIntValue();
        int newType = expectedNumerationSystem.getNumerationSystemIntValue();
        String digit = number.getDigit();

        boolean check = false;
        int decimalDigit = 0;
        Number returnNumber = null;

        //перевірка чи все згадза шє
        try
        {
            if (digit.startsWith("0x") && oldType == 16) check = true;
            else if (digit.startsWith("0b") && oldType == 2) check = true;
            else if (digit.startsWith("0") && oldType == 8) check = true;
            else if (Character.isDigit(digit.charAt(0)) && oldType == 10) check = true;
            else throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println("NumberFormatException "+digit);
            check = false;
        }
        catch (Exception e)
        {
            System.out.println("AnotherError");
            check = false;
        }

        //переводимо в десятичну
        boolean liveDigit = false;
        if (check == true)
        {
            if (digit.startsWith("0x")) decimalDigit = Integer.parseInt(digit.substring(2), 16);
            if (digit.startsWith("0b")) decimalDigit = Integer.parseInt(digit.substring(2), 2);
            if (digit.startsWith("0")) decimalDigit = Integer.parseInt(digit.substring(1), 8);
            else decimalDigit = Integer.parseInt(digit);
            liveDigit = true;
        }

        //переводимо в потрібну нам
        if (liveDigit == true)
        {
            if (newType == 16) //16 0x
                returnNumber = new Number(expectedNumerationSystem, "0x" + Integer.parseInt(Integer.toHexString(decimalDigit)));
            if (newType == 2) //2 0b
                returnNumber = new Number(expectedNumerationSystem, "0b" + Integer.parseInt(Integer.toBinaryString(decimalDigit)));
            if (newType == 8) //8 0
                returnNumber = new Number(expectedNumerationSystem, "0" + Integer.parseInt(Integer.toOctalString(decimalDigit)));
            if (newType == 10)//10
                returnNumber = new Number(expectedNumerationSystem, Integer.toString(decimalDigit));
        }

        return returnNumber;
    }*/


    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String str = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, str);
    }
}
