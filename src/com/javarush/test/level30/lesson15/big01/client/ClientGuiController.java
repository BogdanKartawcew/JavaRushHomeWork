package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by MyWORID on 24.05.2017.
 */
public class ClientGuiController extends Client
{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public class GuiSocketThread extends SocketThread
    {
        protected void processIncomingMessage(String message)
        /*должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления*/
        {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        protected void informAboutAddingNewUser(String userName)
        /*должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения*/
        {
            model.addUser(userName);
            view.refreshUsers();
        }

        protected void informAboutDeletingNewUser(String userName)
        /*должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения*/
        {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        /*должен вызывать аналогичный метод у представления*/
        {
            view.notifyConnectionStatusChanged(clientConnected);
            //super.notifyConnectionStatusChanged(clientConnected);
        }
    }

    protected SocketThread getSocketThread()
    {
        return new GuiSocketThread();
    }

    public void run()
    {
        getSocketThread().run();
    }

    protected String getServerAddress()
    {
        return view.getServerAddress();
    }

    protected int getServerPort()
    {
        return view.getServerPort();
    }

    protected String getUserName()
    {
        return view.getUserName();
    }

    public ClientGuiModel getModel()
    {
        return model;
    }

    public static void main(String[] args)
    {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }
}
