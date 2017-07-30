package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by MyWORID on 28.05.2017.
 */
public class FrameListener extends WindowAdapter
{
    View view;

    public FrameListener(View view)
    {
        this.view = view;
    }

    public void windowClosing(WindowEvent windowEvent)
    {
        view.exit();
    }
}
