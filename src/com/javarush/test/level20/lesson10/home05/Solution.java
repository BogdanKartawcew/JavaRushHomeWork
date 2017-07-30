package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(country);
            out.writeObject(sex);
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            this.firstName = (String) in.readObject();
            this.lastName = (String) in.readObject();
            this.country = (String) in.readObject();
            this.sex = (Sex) in.readObject();
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
