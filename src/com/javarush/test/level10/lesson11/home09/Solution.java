package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }
//===========================================================================================
    //    переходимо до нашоого циклу

        Map<String, Integer> map = countWords(words);
//===========================================================================================
        // виводимо слова на екран
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String word = list.get(i);
            for (int j = i; j < list.size(); j++) {
                if( !result.containsKey(list.get(j)) && word.equals(list.get(j))){
                    count++;
                }
            }
            if(0 < count){
                result.put(list.get(i), count);
            }
       }
        return result;
    }
}
