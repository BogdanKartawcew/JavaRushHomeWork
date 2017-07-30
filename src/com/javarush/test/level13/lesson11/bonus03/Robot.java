package com.javarush.test.level13.lesson11.bonus03;

/*public class Robot implements Attackable, Defensable
{
    private static int hitCount;
    private String name;

    public Robot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }*/
    public class Robot extends AbstractRobot implements Attackable, Defensable
    {
        public Robot(String name)
        {
            super(name);
        }
        public String getName() {return name;}
    }