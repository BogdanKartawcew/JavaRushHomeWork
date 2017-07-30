package com.javarush.test.level30.lesson15.big01;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by MyWORID on 21.05.2017.
 */
public class Connection implements Closeable
{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException
    {
        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }
    }

    public Message receive() throws IOException, ClassNotFoundException
    {
        Message message;

        synchronized (in) {
            message = (Message)in.readObject();
            return message;
        }
    }

    public SocketAddress getRemoteSocketAddress()
    {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException
    {
        out.close();
        in.close();
        socket.close();
    }
}
