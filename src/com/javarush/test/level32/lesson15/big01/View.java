package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MyWORID on 28.05.2017.
 */
public class View extends JFrame implements ActionListener
{
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); //панель с двумя вкладками
    private JTextPane htmlTextPane = new JTextPane(); //компонент для визуального редактирования html. Он будет размещен на первой вкладке
    private JEditorPane plainTextPane = new JEditorPane(); //компонент для редактирования html в виде текста, будет отображать код html

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public View()
    /*Он должен устанавливать внешний вид и поведение (look and feel) нашего приложения такими же, как это определено в системе.*/
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /*Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
        По этой строке ты можешь понять какой пункт меню создал данное событие.*/
        switch (e.getActionCommand())
        {
            case "Новый": controller.createNewDocument();
                break;
            case "Открыть": controller.openDocument();
                break;
            case "Сохранить": controller.saveDocument();
                break;
            case "Сохранить как...": controller.saveDocumentAs();
                break;
            case "Выход": exit();
                break;
            case "О программе": showAbout();
                break;
        }

    }

    public boolean isHtmlTabSelected()
    /*Он должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок*/
    {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void init()
    /*Добавлять слушателя событий нашего окна.*/
    {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        this.setVisible(true); //Показывать наше окно
        /*ex4. На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.*/
    }

    public void exit()
    {
        controller.exit();
    }

    public void initMenuBar()
    /*инициализация меню редактора. Создавать новый объект типа JMenuBar. Это и будет наша панель меню.*/
    {
        JMenuBar jMenuBar = new JMenuBar();
        /*це все задає порядок розташування. порядок має значення*/
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH); //тут різні параметри можна виставляти.
        //Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы делали с панелью вкладок
    }

    public void initEditor() //додали вкладку всередині програми HTML і Текст
    /*инициализация панелей редактора*/
    {
        htmlTextPane.setContentType("text/html"); //Устанавливать значение "text/html" в качестве типа контента
        JScrollPane jSPHTML = new JScrollPane(htmlTextPane); //Создавать новый локальный компонент JScrollPane на базе htmlTextPane
        tabbedPane.add("HTML", jSPHTML); //Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом jSPHTML

        JScrollPane jSPTEXT = new JScrollPane(plainTextPane); //Создавать новый локальный компонент JScrollPane на базе plainTextPane
        tabbedPane.add("Текст", jSPTEXT); //Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом
        tabbedPane.setPreferredSize(new Dimension(800, 600)); //Устанавливать предпочтительный размер панели tabbedPane
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        /*Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane*/
        getContentPane().add(tabbedPane, BorderLayout.CENTER); // навіть якщо не давати центер - воно по умольчанию робиться так
        /*Добавлять по центру панели контента текущего фрейма нашу панель с вкладками. Получить панель контента текущего фрейма
        можно с помощью метода getContentPane()*/
    }

    public void initGui()
    /*будет инициализировать графический интерфейс*/
    {
        initMenuBar();
        initEditor();
        pack();
        /*Metoda pack() ustala rozmiar okna tak, aby mieściły się w nim wszystkie widoczne komponenty.
        Rozmiar okna można również określić samemu przy pomocy metody setSize(int szerokość, int wysokość).
        Aby okno było widoczne na ekranie, trzeba wywołać jego metodę setVisible() z parametrem true.*/
    }

    public void selectedTabChanged()
    /*метод вызывается, когда произошла смена выбранной вкладки*/
    {
        if (isHtmlTabSelected())
        {
            controller.setPlainText(plainTextPane.getText());
        } else
        {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void undo()
    /*отменяет последнее действие*/
    {
        undoManager.undo();
    }

    public void redo()
    /*возвращает ранее отмененное действие*/
    {
        undoManager.redo();
    }

    public void resetUndo()
    /*должен сбрасывать все правки в менеджере undoManager*/
    {
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab()
    /*клавіша HTML*/
    {
        tabbedPane.setSelectedIndex(0); //Выбирать html вкладку (переключаться на нее)
        resetUndo();//Сбрасывать все правки с помощью метода, который ты реализовал ранее
    }

    public void update()
    {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout()
    /*кнопка Інформація*/
    {
        JFrame frame = new JFrame("information");


        JOptionPane.showMessageDialog(frame,
                "Created by Bogdan Kartawcew, June 2017",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
