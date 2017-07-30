package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {

// тупезна задача, яка мене вибісила. це просто копі-паст. треба дивитись зразок попередньої. там норм


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        String name = reader.readLine();
        reader.close();
        BufferedReader listreader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));

        String line;


        while ((line = listreader.readLine()) != null) {


            List<String> list = new ArrayList<>();
            String idWithSpace = line.substring(0, 8);
            String id = idWithSpace.trim();
            String productNameWithSpace = line.substring(8, 38);
            String productName = productNameWithSpace.trim();
            String priceWithSpace = line.substring(38, 46);
            String price = priceWithSpace.trim();
            String quantityWithSpace = line.substring(46, 50);
            String quantity = quantityWithSpace.trim();
            list.add(productName);
            list.add(price);
            list.add(quantity);
            map.put(id, list);
        }
        listreader.close();


        if (args[0].equals("-u")) {
            updateOperation(args,map);
        } else if (args[0].equals("-d")) {
            deleteOperation(args,map);
        }
        int counter = 0;

        BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)));
        for (Map.Entry<String, List<String>> pair : map.entrySet()) {
            String id = pair.getKey().toString();
            String productName = pair.getValue().get(0);
            String price = pair.getValue().get(1);
            String quantity = pair.getValue().get(2);
            String stroka = String.format("%-8.8s%-30.30s%-8.8s%-4.4s",id,productName,price,quantity);
            outputStream.write(stroka);

            counter++;
            if (counter != map.size()) {
                outputStream.newLine();
            }


        }
        outputStream.close();

    }

    public static void updateOperation(String[] args,LinkedHashMap map) throws IOException {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String id = args[1];
        char[] productName1 = new char[30];

        for (int i = 2; i < args.length - 2; i++) {
            sb.append(args[i] + " ");
        }
        char[] productNameFromArgs = sb.toString().toCharArray();
        for (int i = 0; i < productName1.length; i++) {
            if (i == productNameFromArgs.length) break;
            productName1[i] = productNameFromArgs[i];
            sb2.append(productName1[i]);
        }
        String productName = sb.toString();
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        list.add(productName);
        list.add(price);
        list.add(quantity);
        if (map.containsKey(id)) {
            map.put(id, list);
        }
    }


    public static void deleteOperation(String[] args,LinkedHashMap map) {
        if (map.containsKey(args[1]))
            map.remove(args[1]);
    }
}

// C:\Users\MyWORID\Desktop\1.txt