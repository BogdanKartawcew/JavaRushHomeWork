package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {

    /*public static StringBuilder resultMy = new StringBuilder("");
    public static StringBuilder firstWord = new StringBuilder("");
    public static StringBuilder nextWord = new StringBuilder("");
    public static List<String> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        //String filename = "C:\\Users\\MyWORID\\Desktop\\1.txt";
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"Unicode"));
        String[] massyv = new String[0];
        while(in.ready()){
            massyv = in.readLine().split(" ");
        }
        in.close();

        StringBuilder result = getLine(massyv);
        System.out.println(result.toString());}
        catch (Exception e) {}
    }


    public static StringBuilder getLine(String... words) {
        if (words == null) {return new StringBuilder("");}
        if (words.length==0) {return new StringBuilder("");}
        for (String s : words) {
            arrayList.addAll(Arrays.asList(s));
        }
        Collections.shuffle(arrayList);
        resultMy.append(arrayList.get(0)).append(" "); //додаємо в список перше слово
        firstWord = firstWord.replace(0, firstWord.length(), String.valueOf(arrayList.get(0)));
        arrayList.remove(arrayList.get(0));

        for (int i = 0; i < arrayList.size(); i++) {

            String lastLetterOfFirstWord = lastLetter(firstWord);

            for (int l = 0; l < arrayList.size(); l++) {
                nextWord = nextWord.replace(0, nextWord.length(), String.valueOf(arrayList.get(l)));
                String firstLetterOfNextWord = firstLetter(nextWord);

                if (firstLetterOfNextWord.equalsIgnoreCase(lastLetterOfFirstWord))
                {
                    resultMy.append(nextWord).append(" ");
                    firstWord = firstWord.replace(0, firstWord.length(), String.valueOf(nextWord));
                }

            }
        }
        StringBuilder newResult = new StringBuilder(resultMy.replace(0, resultMy.length(), resultMy.substring(0, resultMy.length()-1)));
        return newResult;
    }

    public static String lastLetter (StringBuilder word)
    {
        String lastLetter = "";
        for (int k = 0; k < 1; k++)
        {
            lastLetter = String.valueOf(word.charAt(word.length()-k-1));
        }
        return lastLetter;
    }

    public static String firstLetter (StringBuilder word)
    {
        String firstLetter = "";
        for (int k = 0; k < 1; k++)
        {
            firstLetter = String.valueOf(word.charAt(k));
        }
        return firstLetter;
    }*/ // повністю робоча, повністю моя програма - не проходить тестування

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready())
        {
            String[] s = reader.readLine().split("\\s");
            Collections.addAll(list, s);
        }
        reader.close();
        String[] words = new String[list.size()];
        words = list.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        scanner.close();

    }

    public static StringBuilder getLine(String... words) {
        if (words == null) {return new StringBuilder();}
        if (words.length==0) {return new StringBuilder();}

        //String[] array = i.split(" ");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s: words) {
            arrayList.add(s);
        }
        int neededCounter = arrayList.size();
        StringBuilder resultBuilder = new StringBuilder();
        while (true)
        {
            int wordCounter = 0;
            ArrayList<String> temp = new ArrayList<>(arrayList);
            Collections.shuffle(temp);
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(arrayList.get(0));
            temp.remove(arrayList.get(0));
            boolean canAdd = true;

            while (canAdd)
            {
                {
                    ArrayList<String> toDelete = new ArrayList<>();
                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);
                        // если конец стрингбилдера равен первой букве другого слова
                        if (tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.append(" " + s);
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }
                        // если начало стрингбилдера равно последней букве другого слова "Киев Вена" - "Нью Йорк"
                        if (tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.reverse().append(" " + word);
                            tempBuilder.reverse();
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }
                    }
                    // удаляем уже вставленные слова
                    for (String s : toDelete)
                    {
                        temp.remove(s);
                    }
                    toDelete.clear();
                    // если ни к концу ни к началу нельзя добавить символ - break;
                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);
                        if (!tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()) &&
                                !tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            canAdd = false;
                        }
                    }
                }
                resultBuilder = tempBuilder;
                if (wordCounter==neededCounter-1) {
                    return resultBuilder;
                }
            }
        }
    }
}
