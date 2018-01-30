package com.javarush.test.level05.lesson12.home02;

/* Woman and Woman
1. Внутри класса Solution создай public static классы Woman и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man = new Man("Vlad", 15, "Hell know street"); // создали обьект man и присвоили ему 3 значения, благодаря конструктору
        Man man1 = new Man("Egor", 16, "fckng hole street");// создали обьект man и присвоили ему 3 значения, благодаря конструктору
        Woman woman = new Woman("Lena", 17, "Lenin street"); // создали обьект man и присвоили ему 3 значения, благодаря конструктору
        Woman woman1 = new Woman("Gina", 26, "Stalin square "); // создали обьект man и присвоили ему 3 значения, благодаря конструктору
        System.out.println(man); // Выводим на экран информацию, указанную  объекте man
        System.out.println(man1); //Выводим на экран информацию, указанную  объекте man1
        System.out.println(woman); //Выводим на экран информацию, указанную  объекте woman
        System.out.println(woman1); //Выводим на экран информацию, указанную  объекте woman1
    }  // Выведи их на экран тут
    public static class Man // создали класс Man
    {
        String name; // переменная класса
        int age; // переменная класса
        String address;  // переменная класса
        public Man(String name, int age, String address) // создали конструктор, к классу Man (3 переменные)
        {
            this.name = name; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
            this.age = age; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
            this.address = address; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
        }
        public String toString(){ // обьявили метод toString как написано тута - http://otvety.google.ru/otvety/thread?tid=50e67269b49b7966  Он нужен для цитата " для вывода в форме понятной для человека своих объектов классов, если это для них имеет смысл конечно."
            return name.toString() + " " + age + " " + address.toString(); // в нашем случае мы попросили с помощью данного метода вывести через sout инфу в формате [name + " " + age + " " + address]
        }
    }
    public static class Woman // создали класс Man
    {
        String name; // переменная класса
        int age; // переменная класса
        String address; // переменная класса
        public Woman(String name, int age, String address) // создали конструктор, к классу Woman (3 переменные)
        {
            this.name = name; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
            this.age = age; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
            this.address = address; // Здесь мы указали, что в переменную класса передается значение из переменной конструктора
        }  // Напиши тут свои классы
        public String toString(){
            return name.toString() + " " + age + " " + address.toString(); // в нашем случае мы попросили с помощью данного метода вывести через sout инфу в формате [name + " " + age + " " + address]
        }
    }
}
