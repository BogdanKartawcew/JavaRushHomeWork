package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args)
    {
        Human children = new Human("Ox", false, 23);
        Human children1 = new Human("Bogdan", true, 20);
        Human children2 = new Human("Max", true, 16);
        Human mum = new Human("Halia", false, 45, children, children1, children2);
        Human dad = new Human("Roman", true, 44, children, children1, children2);
        Human grandfather1= new Human("Myron", true, 65, mum);
        Human grandfather2= new Human("Vasyl", true, 77, dad);
        Human grandmother1= new Human("Nastia", false, 66, mum);
        Human grandmother2= new Human("Anna", false, 77, dad);

        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(mum);
        System.out.println(dad);
        System.out.println(children);
        System.out.println(children1);
        System.out.println(children2);
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        ArrayList<Human> children = new ArrayList<Human>();
        Human(String name,boolean sex,int age,Human ... args)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = this.children = new ArrayList<Human>();
            for (Human h : args){
                this.children.add(h);
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }

    }

}
