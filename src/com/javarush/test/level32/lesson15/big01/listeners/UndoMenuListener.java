package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by MyWORID on 03.06.2017.
 */
/*Этот слушатель будет следить за меню, а если конкретнее,
то за моментом, когда меню редактирования будет выбрано пользователем. В этот момент он
будет запрашивать у представления можем ли мы сейчас отменить или вернуть какое-то
действие, и в зависимости от этого делать доступными или не доступными пункты меню
"Отменить" и "Вернуть".*/
public class UndoMenuListener implements MenuListener
{
    private View view;
    private JMenuItem undoMenuItem; //Пункт меню "Отменить"
    private JMenuItem redoMenuItem; //Пункт меню "Вернуть"


    public UndoMenuListener(View view, JMenuItem undoItem, JMenuItem redoItem)
    {
        this.view = view;
        this.undoMenuItem = undoItem;
        this.redoMenuItem=redoItem;
    }

    @Override
    public void menuSelected(MenuEvent e)
    /*будет вызываться перед показом меню. Спрашивать у представления можем ли мы отменить действие*/
    {
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
        /*Делать доступным или не доступным пункт меню undoMenuItem и redoMenuItem в зависимости от того, что нам вернуло представление*/
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
