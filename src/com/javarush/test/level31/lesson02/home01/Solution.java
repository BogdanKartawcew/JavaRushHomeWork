package com.javarush.test.level31.lesson02.home01;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.+
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:+
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке+
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'+
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{
    /*private static TreeMap<String, String> filesNames = new TreeMap<>();

    public static void main(String[] args)
    {
        *//*File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);*//*

        File path = new File("C:/Users/MyWORID/Desktop/tests");
        File resultFileAbsolutePath = new File("C:/Users/MyWORID/Desktop/result.txt");
        sortMap(path);
        String newName = resultFileAbsolutePath.getParent() + "/allFilesContent.txt";
        resultFileAbsolutePath.renameTo(new File(newName));

        LinkedHashSet<String> adress = new LinkedHashSet<>();
        for (Map.Entry<String, String> map : filesNames.entrySet())
        {
            adress.add(map.getValue());
        }

        Iterator iterator = adress.iterator();
        while (iterator.hasNext()){
            String fileName = iterator.next().toString();
            try
            {
                RandomAccessFile fileToRead = new RandomAccessFile(fileName, "r");
                long fileSize = 0, position = 0;
                fileSize = fileToRead.length();
                fileToRead.seek(0);
                while (position < fileSize)
                {
                    stringWriteToFile(newName, fileToRead.readLine());
                    position = fileToRead.getFilePointer();
                }
                fileToRead.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    private static void stringWriteToFile(String filename, String toWrite) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        file.seek(file.length());
        file.writeUTF(toWrite);
        file.close();
    }

    private static void sortMap(File path)
    {
        for (File file : path.listFiles())
        {
            if (file.length() < 50) file.delete();
            else
            {
                String[] fileName = file.getName().split(".txt");
                filesNames.put(fileName[0], file.getAbsolutePath());
            }
        }
        for (File file : path.listFiles())
        {
            if (file.isDirectory()) sortMap(file.getAbsoluteFile()); // здається тут мало бути getAbsolutePath(), але і так працює
        }
    }*/ //мій повністю робочий варіант - не проходить


    public static void main(String[] args) throws IOException {
        String directoryPath = args[0];
        String resultFileAbsolutePath = args[1];
        //String directoryPath = "src/main/resources/level31/lesson02/home01";
        //String resultFileAbsolutePath = "src/main/resources/level31/lesson02/home01/res.txt";
        String allFilesContent = "allFilesContent.txt";

        saveFilesLessThan50Bytes(directoryPath);

        // rename file
        Path source = Paths.get(resultFileAbsolutePath);
        Path newResPath = Files.move(source, source.resolveSibling(allFilesContent));

        // delete resultFileAbsolutePath if list contains it
        lessThan50BytesFiles.remove(new File(resultFileAbsolutePath));

        // sort file by name
        Collections.sort(lessThan50BytesFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });

        // write to result file
        BufferedWriter fout = new BufferedWriter(new FileWriter(newResPath.toFile()));
        for (File file : lessThan50BytesFiles) {
            BufferedReader fin = new BufferedReader(new FileReader(file));
            while (fin.ready()) {
                fout.write(fin.readLine());
                fout.newLine();
            }
            fin.close();
        }
        fout.close();
    }

    private static List<File> lessThan50BytesFiles = new ArrayList<>();

    private static void saveFilesLessThan50Bytes(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();

        if (files == null) {
            // it is not directory
            return;
        } else if (files.length == 0) {
            // directory is empty
            dir.delete();
        } else {
            for (File file : files) {
                if (file.isDirectory()) {
                    // nested directory
                    saveFilesLessThan50Bytes(file.getAbsolutePath());
                } else {
                    if (file.length() > 50) {
                        file.delete();
                    } else {
                        lessThan50BytesFiles.add(file);
                    }
                }
            }
        }
    }
}
