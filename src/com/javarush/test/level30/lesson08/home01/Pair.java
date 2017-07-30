package com.javarush.test.level30.lesson08.home01;

public class Pair
{
    private int x;
    private int y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap()
    {
        x = x ^ y; // x==1
        y = x ^ y; // y==4
        x = x ^ y; // x==5

        //але взагаліто такий код не дає ніякого виграшу у швидкості в порівнянні з простими методами

        /*x = x + y;
        y = y - x;
        y = -y;
        x = x - y;*/
    }
}
