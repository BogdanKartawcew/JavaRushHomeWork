package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private String filename = null;

    public Circle(int centerX, int centerY, int radius)
    {

    }
    public Circle(int width, int centerX, int radius, int centerY)
    {

}
    public Circle(String color, int width, int centerX, int centerY, int radius)
    {
        this.filename = centerX + centerY + radius+width+color;
    }

}
