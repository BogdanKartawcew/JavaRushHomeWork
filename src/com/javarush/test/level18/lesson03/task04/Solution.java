package com.javarush.test.level18.lesson03.task04;


/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream in = new FileInputStream(reader.readLine());
        reader.close();
        while(in.available() > 0) {
            int tmp = in.read();
            if(map.containsKey(tmp))
                map.put(tmp, map.get(tmp) +1);
            else
                map.put(tmp, 1);
        }
        in.close();
        System.out.println(map);

        int count = Integer.MAX_VALUE; //ми вибираємо максимум із чисел.

        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()) { //виділяємо
            if(mapEntry.getValue()< count) {
                count = mapEntry.getValue(); //якщо якесь з чисел менше ніж максимум, то це менше число стає максимумом.
                // таким чином ми знаходимо найменше число.
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if(mapEntry.getValue() == count) //тепер всі КЕУ, VALUE яких дорівнює найменшому числу - додаємо в список
                list.add(mapEntry.getKey());
        }

        System.out.print(list);
    }
}     /*цей варіант прийняло з результатом =
        {192=1, 193=1, 49=1, 50=3, 51=3, 212=1, 52=2, 70=1, 219=1, 77=1}
[192, 193, 49, 212, 70, 219, 77]*/


//     C:\Users\MyWORID\Desktop\1234.txt

// 49 70 77 144 145 164 171 - правильний вивід