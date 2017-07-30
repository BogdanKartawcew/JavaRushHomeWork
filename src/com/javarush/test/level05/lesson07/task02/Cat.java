package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String filename = null;
    public void initialize(String name)
    {
        this.filename = name;
    }

    public void initialize(String name, int weight, int age)
    {
        this.filename = name + weight + age;
    }

    public void initialize(int age, String name)
    {
        this.filename = age + name;
    }

    public void initialize(String colour, int weight)
    {
        this.filename = colour + weight;
    }

    public void initialize(String colour, int weight, String adress)
    {
        this.filename = colour + weight + adress;
    }
//напишите тут ваш код

}
