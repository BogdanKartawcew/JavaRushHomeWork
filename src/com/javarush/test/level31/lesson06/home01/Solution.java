package com.javarush.test.level31.lesson06.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution
{

    private static String fileWholeName = "C:/Users/MyWORID/Desktop/Новая папка/testMP3.mp3";
    private static String zipFileWholeName = "C:/Users/MyWORID/Desktop/Новая папка/test.zip";
    public static void main(String[] args) throws IOException
    {
        File file = new File(fileWholeName);
        byte[] buffer = new byte[(int) file.length()];
        String fileName = "new/" + file.getName(); // створюємо назву файла в папці new

        unZipIt();
        try
        {
            ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFileWholeName)); // створюємо вихід зіп
            ZipEntry resultZip = new ZipEntry(fileName);
            zip.putNextEntry(resultZip); // відкриваємо канал для запису
            FileInputStream inputStream = new FileInputStream(fileWholeName); // відкриваємо канал для читання байтів нашого файлу

            int bytes;
            while ((bytes = inputStream.read(buffer)) > 0) // читаємо байти нашого файлу
            {
                zip.write(buffer, 0, bytes); // записуємо байти файлу в архів
            }

            /*закриваємо всі відкриті канали*/
            inputStream.close();
            zip.closeEntry();
            zip.close();

            System.out.println("Done");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private static HashMap<String, byte[]> map = new HashMap<>();

    public static void unZipIt()
    {
        File file = new File(fileWholeName);
        byte[] buffer = new byte[(int) file.length()];

        try
        {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileWholeName));
            ZipEntry ze = zis.getNextEntry();

            while (ze != null)
            {

                String fileName = ze.getName();
                System.out.println(fileName);
                /*File newFile = new File(outputFolder + File.separator + fileName);

                System.out.println("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0)
                {
                    fos.write(buffer, 0, len);
                }*/
            }
            zis.closeEntry();
            zis.close();

            System.out.println("Done");

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }





   /* public static Map <ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File zipArchive = new File(args[1]);
        File addedFile = new File(args[0]);

        zipToMap(zipArchive);
        addNewFileToZIP(addedFile, zipArchive);
    }


    public static void zipToMap(File file)  {

        // Записываем содержимое архива в карту
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {

            ZipEntry zipEntry;

            // перебираем все zipEntries
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addNewFileToZIP(File addedFile, File zipArchive) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive)); FileInputStream fileInputStream = new FileInputStream(addedFile)) {

            //Маркер наличия добавляемого файла в архиве
            boolean isExist = false;

            //Сохраняем сразу в отдельный zipEntry добавляемый файл для последующего сравнения
            ZipEntry fileNameComparator = new ZipEntry(addedFile.getName());


            //Копируем zipEntry с entryMap в архив
            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {


                //Подрезаем путь файла для сравненияс добавляемым файлом
                Path path = Paths.get(zipEntry.getKey().getName());

                //Сравниваем...
                //Если имя текущего файла в zipEntry НЕ совпадает с добавлемым файлом
                if(!(path.getFileName().toString().equals(fileNameComparator.getName()))) {

                    //Записываем в архив
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());

                }
                //Если же файл с таким названием присутствует в архиве...
                else {
                    isExist = true;
                }
            }

            //Если в процессе прохождения цикла в архиве нашелся файл с таким-же именем как и добавляемый..
            if (isExist) {
                //Добавляем файл в папку new
                ZipEntry addingFileEntry = new ZipEntry("new/" + addedFile.getName());
                zipOutputStream.putNextEntry(addingFileEntry);

                //Считываем содержимое файла в массив byte
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);

                //Добавляем содержимое к архиву
                zipOutputStream.write(buffer);
                //Закрываем текущую запись для новой записи
                zipOutputStream.closeEntry();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
