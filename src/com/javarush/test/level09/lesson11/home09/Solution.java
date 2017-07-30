package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {Map <String, Cat> map = new HashMap<String, Cat>();

        map.put("Name1", new Cat("Cat1"));
        map.put("Name2", new Cat("Cat2"));
        map.put("Name3", new Cat("Cat3"));
        map.put("Name4", new Cat("Cat4"));
        map.put("Name5", new Cat("Cat5"));
        map.put("Name6", new Cat("Cat6"));
        map.put("Name7", new Cat("Cat7"));
        map.put("Name8", new Cat("Cat8"));
        map.put("Name9", new Cat("Cat9"));
        map.put("Name10", new Cat("Cat10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
//        Set<Cat> set = new HashSet<Cat>();
//
//        for ( String key : map.keySet() )                      //у мене воно по такому типу виводиться список імен. тоді можна закментити команду в меін прінт кет,
//            System.out.println( key );                         //і закоментити теж метод прінт кет цілий
//             return set;
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> m : map.entrySet()) set.add(m.getValue());;
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
