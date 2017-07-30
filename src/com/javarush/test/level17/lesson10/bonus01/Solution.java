package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            String name =args[1];

            Date strDate = sdf.parse(args[3]);

            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(name, strDate));
            } else if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(name, strDate));
            }
            System.out.println(allPeople.size() - 1);
        }

        if (args[0].equals("-u")) {

            Date strDate = sdf.parse(args[4]);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setBirthDay(strDate);

            if (args[2].equals("м")) {
                person.setSex(Sex.MALE);
            } else if (args[2].equals("ж")) {
                person.setSex(Sex.FEMALE);
            }
        }

        if (args[0].equals("-d")) {
            Person per = allPeople.get(Integer.parseInt(args[1]));
            per.setName(null);
            per.setSex(null);
            per.setBirthDay(null);
        }

        if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            String sex = "";
            if (person.getSex().equals(Sex.MALE)) {
                sex = "м";
            }
            else if (person.getSex().equals(Sex.FEMALE)) {
                sex = "ж";
            }

            sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);

            String bd = sdf.format(person.getBirthDay());

            System.out.println(person.getName() + " " + sex + " " + bd);
        }
    }
}
