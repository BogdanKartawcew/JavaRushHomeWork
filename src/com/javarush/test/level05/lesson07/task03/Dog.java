package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String filename = null;
    public void initialize(String name)
    {
        this.filename = name;
    }

    public void initialize(String name, int rost)
    {
        this.filename = name + rost;
    }

    public void initialize(String name, int rost, String colour)
    {
        this.filename = name + rost + colour;
    }
}
