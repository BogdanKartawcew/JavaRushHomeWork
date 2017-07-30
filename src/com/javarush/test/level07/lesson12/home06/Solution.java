package com.javarush.test.level07.lesson12.home06;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {   Human grandFather1 = new Human("Ded1", true, 80, null, null);
        Human grandFather2 = new Human("Ded2", true, 80, null, null);
        Human grandMother1 = new Human("Baba1", false, 70, null, null);
        Human grandMother2 = new Human("Baba2", false, 70, null, null);
        Human father = new Human("Papa", true, 45, grandFather1, grandMother1);      //обявляємо наші обєкти, хто з них що має. а потім виводи на екран тих, кого маємо.
        Human mother = new Human("Mama", false, 35, grandFather2, grandMother2);   // по суті тут ще створюємо самі обєкти і заповнюємо їх. якось це теж ще можна вводити з клавіатури.
        Human child1 = new Human("Detka1", false, 20, father, mother);   // про те,як вводити дані з клавіатури, є у задачі левел 7, лессон 12, бонус 01
        Human child2 = new Human("Detka2", true, 18, father, mother);
        Human child3 = new Human("Detka3", false, 10, father, mother);
        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        private String name;   // тут обявляємо типи наших даних.
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский"); // тут якщо тру, то перше, якщо фолс при булін, то друге. це просто компактний запис. варто собі його запамятати.
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
