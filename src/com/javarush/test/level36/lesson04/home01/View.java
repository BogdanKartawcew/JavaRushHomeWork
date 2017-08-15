package com.javarush.test.level36.lesson04.home01;

public class View
{
    Controller controller = new Controller();

    public void fireEventShowData()
    { //view
        System.out.println(controller.onDataListShow());
    }
}
