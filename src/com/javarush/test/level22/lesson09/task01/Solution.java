package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/

//C:\Users\MyWORID\Desktop\1.txt


/*мій код працює ідеально. той код, який прийнявся - я провіряв його - він працює погано. при цьому в ідеї навіть не компілюється,якщо без змін*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Unicode"));
        LinkedList<String> linkedList = new LinkedList<>();
        while(in.ready()){
            String[] massyv = in.readLine().split(" ");
            for (String s:massyv)
            {
                linkedList.addAll(Arrays.asList(s));
            }
        }
        in.close();

        List<String> arrayList = new ArrayList<String>(linkedList);

        for (int i = 0; i<arrayList.size()-1; i++)
        {
            String reverseWord = new StringBuilder(arrayList.get(i)).reverse().toString();
            String nextWord = arrayList.get(i+1);
            if (reverseWord.equals(nextWord))
            {
                Pair pair = new Pair();
                pair.first = arrayList.get(i); pair.second=arrayList.get(i+1);
                result.add(pair);
                arrayList.remove(i);
                arrayList.remove(i+1);
            }
        }

        for (Pair s:result)
        {
            System.out.println("s: " +s);
        }*/ // - повністю робочий код, який не приймається.


        BufferedReader pathReading = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> wordsSet = new LinkedList<>();
        String path = null;
        try {
            path = pathReading.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while(bufferedReader.ready()) {
                String[] splittedWords = bufferedReader.readLine().split(" ");
                wordsSet.addAll(Arrays.asList(splittedWords));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 1; i <= wordsSet.size() - 2; i++) {
            findPairAndRemovefromList(wordsSet);
        }
    }

    public static void findPairAndRemovefromList(LinkedList<String> listOfWords) {
        StringBuilder word1 = new StringBuilder(listOfWords.get(0));
        StringBuilder word2 = new StringBuilder();

        for (int i = 1; i <= listOfWords.size() - 1; i++) {
            word2.setLength(0);
            word2.append(listOfWords.get(i));
            if (word1.toString().equals(word2.reverse().toString())) {
                Pair pair = new Pair();
                pair.first = word1.toString(); pair.second=word2.reverse().toString();
                result.add(pair);
                //result.add(new Pair(word1.toString(), word2.reverse().toString())); таким воно було, але воно тоді не компілюється
                listOfWords.remove(0);
                listOfWords.remove(i - 1);
                return;
            }
        }
        listOfWords.remove(0);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
