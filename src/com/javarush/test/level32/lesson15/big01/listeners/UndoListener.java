package com.javarush.test.level32.lesson15.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by MyWORID on 04.06.2017.
 */
/*Этот класс будет следить за правками, которые можно отменить или вернуть*/
public class UndoListener implements UndoableEditListener
{
    private UndoManager undoManager; //дуже важливий клас (дивитись доки)

    public UndoListener(UndoManager undoManager)
    {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e)
    /*Он должен из переданного события получать правку и добавлять ее в undoManager*/
    {
        undoManager.addEdit(e.getEdit());
    }
}
