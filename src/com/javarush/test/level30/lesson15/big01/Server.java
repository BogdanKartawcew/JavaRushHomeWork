package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MyWORID on 21.05.2017.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException
    {
        ConsoleHelper.writeMessage("Введіть порт сервера (число)");
        int portServer = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(portServer);)
        {
            ConsoleHelper.writeMessage("Сервер завантажений");
            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start(); //тому що це у нас нова нить
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Помилка серверного зєднання");
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet())
            {
                map.getValue().send(message);
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Помилка відправлення повідомлення. Спробуйте ще раз.");
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }


        public void run()
        /*будет вызывать все вспомогательные методы, написанные ранее*/
        {
            String newClientName = null;
            try(Connection connection = new Connection(socket)) //Создавать Connection, используя поле Socket
            {
                /*Выводит сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress*/
                ConsoleHelper.writeMessage(String.format("Встановлення зєднання з сервером: %s", connection.getRemoteSocketAddress()));

                try
                {
                    newClientName = serverHandshake(connection); //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClientName)); //Рассылать всем участникам чата информацию об имени присоединившегося участника
                    sendListOfUsers(connection, newClientName);  //Сообщать новому участнику о существующих участниках
                    serverMainLoop(connection, newClientName); //Запускать главный цикл обработки сообщений сервером
                    ConsoleHelper.writeMessage("Зєднання з сервером встановлено");
                }
                catch (ClassNotFoundException e)
                {
                    socket.close(); //Обеспечить закрытие соединения при возникновении исключения
                    ConsoleHelper.writeMessage("Помилка при запуску сервера");
                }
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Помилка при запуску сервера");
            }
            connectionMap.remove(newClientName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClientName));
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        /*этап рукопожатия (знакомства сервера с клиентом)*/
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST)); //Сформировать и отправить команду запроса имени пользователя
                Message answer = connection.receive(); //Получить ответ клиента
                if (answer.getType() == MessageType.USER_NAME) //Проверить, что получена команда с именем пользователя
                {
                    String newClientName = answer.getData(); //Достать из ответа имя
                    if (!newClientName.isEmpty() && newClientName != null && !newClientName.equals("") && !connectionMap.containsKey(newClientName))
                    /*проверить, что оно не пустое и пользователь с таким именем еще не подключен (используй connectionMap)*/
                    {
                        connectionMap.put(newClientName, connection); //Добавить нового пользователя и соединение с ним в connectionMap
                        connection.send(new Message(MessageType.NAME_ACCEPTED)); //Отправить клиенту команду информирующую, что его имя принято
                        return newClientName; //Вернуть принятое имя в качестве возвращаемого значения
                    }
                }
                //Если какая-то проверка не прошла, заново запросить имя клиента
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        /*отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата*/
        {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) //Пройтись по connectionMap
            {
                // У каждого элемента получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем
                if (!userName.equals(map.getKey()))
                    connection.send(new Message(MessageType.USER_ADDED, map.getKey()));
                //Отправить сформированную команду через connection
                //Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        /*главный цикл обработки сообщений сервером*/
        {
            while (true)
            {
                Message answer = connection.receive(); //Принимать сообщение клиента
                if (answer.getType() == MessageType.TEXT)
                {
                    String message = userName.concat(": ").concat(answer.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, message));
                } else
                {
                    ConsoleHelper.writeMessage("Помилка. Повідомлення не є текстовим");
                }
            }
        }
    }
}
