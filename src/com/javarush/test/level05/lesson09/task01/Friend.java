package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String Kigi = null;//напишите тут ваш код

    public Friend(String name)
    {
        this.Kigi = name;
    }

    public Friend(String name, int age)
    {
        this.Kigi = name+age;
    }
    public Friend(String name, int age, String sex)
    {
        this.Kigi = name+age+sex;
    }


}