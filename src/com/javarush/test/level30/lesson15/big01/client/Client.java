package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by MyWORID on 23.05.2017.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public void run()
    //Приступим к написанию главного функционала класса Client.
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start(); //тут здається також ран() можна
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Помилка під час очікування");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        String message;
        while (clientConnected)
        {
            if ((message = ConsoleHelper.readString()).equals("exit")) break;

            else
            {
                if (shouldSentTextFromConsole())
                {
                    sendTextMessage(message);
                }
            }
        }
    }


    public class SocketThread extends Thread
    {
        public void run()
        {
            String serverAdress = getServerAddress();
            int serverPort = getServerPort();
            try
            {
                Socket socket = new Socket(serverAdress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message)
        //должен выводить текст message в консоль
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        //должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату
        {
            ConsoleHelper.writeMessage(userName + "  щойно приєднався до чату");
        }

        protected void informAboutDeletingNewUser(String userName)
        //должен выводить в консоль, что участник с именем userName покинул чат
        {
            ConsoleHelper.writeMessage(userName + "  покинув чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        //"рукопожатие" клиента с сервером
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (message.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    break;
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        //основной цикл обработки сообщений сервера
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED)
                {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED)
                {
                    informAboutDeletingNewUser(message.getData());
                } else throw new IOException("Unexpected MessageType");
            }
        }
    }


    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введіть адресу сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введіть порт сервера (числа)");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введіть імя користувача");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try
        {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Помилка під час відправлення повідомлення.");
            clientConnected = false;
        }
    }
}
