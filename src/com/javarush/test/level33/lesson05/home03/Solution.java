package com.javarush.test.level33.lesson05.home03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть его.
*/
public class Solution
{

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException
    {
        ObjectMapper om = new ObjectMapper();
        File file = new File(fileName);
        return om.readValue(file, clazz);

        /*String jsonString = "{ \"name\"=\"Murka\", \"age\"=5, \"weight\"=4}";
         StringReader reader = new StringReader(jsonString);
         ObjectMapper mapper = new ObjectMapper();
         Cat cat = mapper.readValue(reader, Cat.class);
         з лекції*/
    }
}
