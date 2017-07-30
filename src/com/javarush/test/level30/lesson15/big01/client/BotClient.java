package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by MyWORID on 24.05.2017.
 */
public class BotClient extends Client
{
    public static void main(String[] args)
    {
        BotClient bot1 = new BotClient();
        bot1.run();
    }

    public class BotSocketThread extends Client.SocketThread
    {
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        //основной цикл обработки сообщений сервера
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message)
        //должен выводить текст message в консоль
        {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":"))
            {
                String name;
                String command;
                String[] array = message.split(": ");
                name = array[0];
                command = array[1];
                SimpleDateFormat answer = null;
                switch (command)
                {
                    case "дата":
                        answer = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        answer = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        answer = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        answer = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        answer = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        answer = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        answer = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        answer = new SimpleDateFormat("s");
                        break;
                }
                if (answer != null)
                {
                    /*connection.send(new Message(MessageType.TEXT, */
                    sendTextMessage("Информация для " + name + ": " + answer.format(Calendar.getInstance().getTime()));
                }
            }
        }
    }

    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    private static int botsNumber = 0;

    protected String getUserName()
    {
        if (botsNumber > 99) botsNumber = 0;
        botsNumber++;
        return "date_bot_" + botsNumber;
    }

}
