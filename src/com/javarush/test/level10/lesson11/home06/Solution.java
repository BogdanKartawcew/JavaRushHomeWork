package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public String race;
        public int size;
        public String color;
        Human(String name,boolean sex,int age, String race, int size, String color)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.race = race;
            this.size = size;
            this.color = color;
        }
        Human(String name,boolean sex)
        {this.name = name;
            this.sex = sex;}
        Human(String name)
        {this.name = name;}
        Human(String name,boolean sex,int age)
        {this.name = name;
            this.sex = sex;
            this.age = age;}
        Human(String name,boolean sex,int age, String race)
        {this.name = name;
            this.sex = sex;
            this.age = age;
            this.race = race;}
        Human(String name,boolean sex,int age, String race, int size)
        {this.name = name;
            this.sex = sex;
            this.age = age;
            this.race = race;
            this.size = size;}
        Human(String name,String race )
        {this.name = name;
            this.race = race;}
        Human(String name,String race, int age)
        {this.name = name;
            this.race = race;
            this.age = age;}
        Human(String name,String race, int age, String color)
        {this.name = name;
            this.race = race;
            this.age = age;
            this.color = color;}
        Human(int age, String race, int size)
        {this.age = age;
            this.race = race;
            this.size = size;}

    }
}
