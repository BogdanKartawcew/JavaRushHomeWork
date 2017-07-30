package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String CatFile = null;
    private int weight = 3;
    private int age = 5;
    private String color = "grey";

    public Cat(String name)
    {
        this.CatFile = name;
    }
    public Cat(String name, int weight, int age)
{
    this.CatFile = name + age + weight;
}
    public Cat(String name, int age)
    {
        this.CatFile = name + age;
    }
    public Cat( int weight, String color)
    {
        this.CatFile = color + weight;
    }
    public Cat(int weight, String color, String address)
    {
        this.CatFile = color + address + weight;
    }



}
