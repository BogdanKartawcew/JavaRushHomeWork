package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    /*public static void main (String args[]) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\MyWORID\\Desktop\\1.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"Cp1251"));
        Scanner scanner = new Scanner(bufferedReader);
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(personScannerAdapter.read().toString());

    }*/
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }
        @Override
        public Person read() throws IOException {
            String[] data = scanner.nextLine().split(" ");
            Calendar birthDate = new GregorianCalendar(Integer.parseInt(data[5]), Integer.parseInt(data[4])-1 /*треба відняти один,бо дає на місяць вперед*/,
                    Integer.parseInt(data[3]));
            return new Person(data[1], data[2], data[0], birthDate.getTime()); //порядок data[] має значення. в цьому порядку буде передавати в інший клас. так само при даті
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }

    }
}
