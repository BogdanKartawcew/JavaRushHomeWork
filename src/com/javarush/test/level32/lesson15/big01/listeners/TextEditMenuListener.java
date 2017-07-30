package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by MyWORID on 03.06.2017.
 */
/*Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда,
 когда в нашем редакторе выбрана первая вкладка. (HTML)*/
public class TextEditMenuListener implements MenuListener
{
    private View view;

    public TextEditMenuListener(View view)
    {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e)
    {
        JMenu menu = (JMenu) e.getSource(); //Из переданного параметра получать объект, над которым было совершено действие
        Component[] item =  menu.getMenuComponents(); //У полученного меню получать список компонентов (пунктов меню)
        for (Component component : item){
            component.setEnabled(view.isHtmlTabSelected());
        }
        /*Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра
        результат вызова метода isHtmlTabSelected() из представления*/
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }
}
