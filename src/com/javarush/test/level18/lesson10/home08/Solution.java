package com.javarush.test.level18.lesson10.home08;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    /*public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        while(!isExit)
        {
            String fileName = reader.readLine();
            ReadThread myThread = new ReadThread(fileName);
            isExit = fileName.equals("exit");
        }
        reader.close();                      // це я добавив потім
        System.out.println(resultMap);       // це я добавив потім
    }

    public static class ReadThread extends Thread
    {
        private String filename;

        public ReadThread(String fileName) throws IOException
        {
            this.filename = fileName;
            start();
        }

        public void run()
        {
            try
            {
                FileInputStream file = new FileInputStream(filename);
                HashMap<Integer, Integer> map = new HashMap<>();
                while (file.available() > 0)
                {
                    int tmp = file.read();
                    if (map.containsKey(tmp))
                        map.put(tmp, map.get(tmp) + 1);
                    else
                        map.put(tmp, 1);
                }
                file.close();
                int maxValue = 0;
                int maxByte = 0;

                for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    Integer value = pair.getValue();
                    if (value > maxValue) {
                        maxValue = value;
                    }
                }
                for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getValue().equals(maxValue)) {
                        maxByte = pair.getKey();
                    }
                }

                resultMap.put (filename, maxByte);
            }

            catch (IOException e)
            {
                System.out.println("ERROR");
            }
        }
    }*/
    //такий варіант ідеально працює, але програма не компілюється на сервері
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        while (!"exit".equals(fileName))
        {
            ReadThread myThread = new ReadThread(fileName);
            myThread.start();
            fileName = reader.readLine();
        }
        System.out.println(resultMap);   //задача не проходила аж поки я не поклав сюди вивід на екран!!!!!!!!!!!
        reader.close();
    }

    public static class ReadThread extends Thread
    {
        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream inputStream = new FileInputStream(fileName);
                TreeMap<Integer, Integer> map = new TreeMap<>();
                int max = 1;
                while (inputStream.available() > 0)
                {
                    Integer next = (Integer) inputStream.read();
                    if (map.containsKey(next))
                    {
                        Integer value = map.get(next);
                        ++value;
                        map.put(next, value);
                        max = Math.max(max, value);
                    } else
                    {
                        map.put(next, 1);
                    }
                }

                for (Map.Entry pair : map.entrySet())
                {
                    Integer value = (Integer) pair.getValue();
                    Integer key = (Integer) pair.getKey();
                    if (value.equals(max))
                        resultMap.put(fileName, (int)key);
                }

                inputStream.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("There is not such file!");
            }
            catch (IOException e)
            {
                System.out.println("ANOTHER ERROR");
            }
        }

        private String fileName;
    }

}

// C:\Users\MyWORID\Desktop\789.txt