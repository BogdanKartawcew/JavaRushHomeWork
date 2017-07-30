package com.javarush.test.level33.lesson05.home04;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* Конвертация из одного класса в другой используя JSON
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject,
значения полей которого равны значениям полей в объекте one.
Известно, что у классов есть Json аннотация, у которой значение проперти равно имени класса в нижнем регистре.
На примере класса First, это className="first"
Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(convertOneToAnother(new First(), Second.class));
        System.out.println();
        System.out.println(convertOneToAnother(new Second(), First.class));
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException
    {
        StringWriter writer = new StringWriter(); // сюди будемо писати результат серіалізації
        ObjectMapper mapper = new ObjectMapper(); // це обєкт Jackson який виконує серіалізацію
        mapper.writeValue(writer, one); // сама серіалізація - куди записуємо і що
        String jsonString = writer.toString(); //тут отримуємо з нашого врайтера строку з даними першого обєкту
        jsonString = jsonString.replaceFirst(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
        //тут находимо слово НАЗВУ ПЕРШОГО КЛАСУ і змінюємо його НАЗВОЮ ДРУГОГО КЛАСУ
        StringReader reader = new StringReader(jsonString); // тепер створюємо звідки будемо читати при ДЕСЕРІАЛІЗАЦІЇ. кладемо туди наш String
        return mapper.readValue(reader, resultClassObject); //повертаємо саму ДЕСЕРІАЛІЗАЦІЮ (її результат)
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First
    {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second
    {
        public int i;
        public String name;
    }
}
