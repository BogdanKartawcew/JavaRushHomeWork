package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/



/*вставлений код. я не до кінця його розумію і, здається, можна було придумати краще. знизу закоментовані мої спроби (які теж скопійовані і редаговані мною)*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("@");
            if (this.users.size() > 0) {
                for (User current : this.users) {
                    StringBuilder sb = new StringBuilder();
                    String hasFirstName = (current.getFirstName() != null) ? "yes" : "no";
                    if ("yes".equals(hasFirstName))
                        sb.append(current.getFirstName()).append(" ");
                    else
                        sb.append("- ");

                    String hasLastName = (current.getLastName() != null) ? "yes" : "no";
                    if ("yes".equals(hasLastName))
                        sb.append(current.getLastName()).append(" ");
                    else
                        sb.append("- ");

                    String hasBirthDate = (current.getBirthDate() != null) ? "yes" : "no";
                    if ("yes".equals(hasBirthDate))
                        sb.append(current.getBirthDate().getYear()).append(" ").append(current.getBirthDate().getMonth()).append(" ").append(current.getBirthDate().getDate()).append(" ");
                    else
                        sb.append("- - - ");

                    if (current.isMale())
                        sb.append(true).append(" ");
                    else
                        sb.append(false).append(" ");

                    String hasCountry = (current.getCountry() != null) ? "yes" : "no";
                    if ("yes".equals(hasCountry))
                        sb.append(current.getCountry().getDisplayedName()).append(" ");
                    else
                        sb.append("- ");
                    printWriter.println(sb.toString());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            if (line.equals("@"))
                line = reader.readLine();
            while (line != null) {
                User user = new User();
                String[] lineArray = line.split(" ");
                if (!"-".equals(lineArray[0]))
                    user.setFirstName(lineArray[0]);
                if (!"-".equals(lineArray[1]))
                    user.setLastName(lineArray[1]);
                if (!"-".equals(lineArray[2]))
                    user.setBirthDate(new Date(Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]), Integer.parseInt(lineArray[4])));
                user.setMale(Boolean.parseBoolean(lineArray[5]));
                if (!"-".equals(lineArray[6]))
                {
                    User.Country country;
                    switch (lineArray[6])
                    {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        default:
                            country = User.Country.OTHER;
                            break;
                    }
                    user.setCountry(country);
                }
                this.users.add(user);
                line = reader.readLine();
                if ("@".equals(line))
                    break;
            }
            reader.close();
        }
    }
}

/*public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter writer = new PrintWriter(outputStream);
            *//*if (!users.isEmpty())
            {
                for (User user : users)
                {
                    writer.println("yes");
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                }
            }*//*

            if (users.size() > 0)
            {
                for (User user : users)
                {
                    if (user.getFirstName() != null) writer.write(user.getFirstName());
                    //else writer.write("error");
                    if (user.getLastName() != null) writer.write(user.getLastName());
                    //else writer.write("error");
                    if (user.getBirthDate() != null) writer.write(new SimpleDateFormat("dd/MM/yyyy").format(user.getBirthDate()));
                    //else writer.write("error");
                    writer.write(String.valueOf(user.isMale()));
                    if (user.getCountry() != null) user.getCountry().getDisplayedName();
                    *//*{
                        if (user.getCountry() == User.Country.UKRAINE) writer.write("Ukraine");
                        else if (user.getCountry() == User.Country.RUSSIA) writer.write("Russia");
                        else if (user.getCountry() == User.Country.OTHER) writer.write("Other");
                    }*//*
                    //else writer.write("error");

                }

            }
            //else writer.write("Any user doesn't exist!");
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            *//*SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (reader.readLine().equals("yes") && users !=null)
            {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(format.parse(reader.readLine()));
                user.setMale(Boolean.valueOf(reader.readLine()));
                String p=reader.readLine();
                if (p.equals(User.Country.UKRAINE.toString()))
                {
                    user.setCountry(User.Country.UKRAINE);
                } else if (p.equals(User.Country.RUSSIA.toString()))
                {
                    user.setCountry(User.Country.RUSSIA);
                } else if (p.equals(User.Country.OTHER.toString()))
                {
                    user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
            reader.close();*//*

            String line = "";
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            User user = new User();
            while (reader.ready()) {
                line = reader.readLine();
                //if (line.equals("Any user doesn't exist!")) break;
                if (line==null) break;
                //if (!line.equals("error")) user.setFirstName(line);
                if (line!=null) user.setFirstName(line);
                line = reader.readLine();
                //if (!line.equals("error")) user.setLastName(line);
                if (line!=null) user.setLastName(line);
                line = reader.readLine();
                //if (!line.equals("error")) user.setBirthDate(format.parse(line));
                if (line!=null) user.setBirthDate(format.parse(line));
                line = reader.readLine();
                //if (!line.equals("error")) {
                if (line.equals("true")) user.setMale(true);
                else user.setMale(false);
                if (line!=null) {
                    if (line.equals("Ukraine")) user.setCountry(User.Country.UKRAINE);
                    else if (line.equals("Russia")) user.setCountry(User.Country.RUSSIA);
                    else if (line.equals("Other")) user.setCountry(User.Country.OTHER);
                }
                line = reader.readLine();
                users.add(user);
            }
        }
    }
}*/