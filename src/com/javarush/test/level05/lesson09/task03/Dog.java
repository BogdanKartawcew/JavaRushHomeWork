package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String filename = null;

    public Dog(String name)
    {
        this.filename = name;
    }
    public Dog(int age, String name)
    {
        this.filename = name+age;
    }
    public Dog(String color, int age, String name)
    {
        this.filename = name+color+age;
    }


}
