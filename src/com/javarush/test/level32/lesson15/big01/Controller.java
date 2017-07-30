package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by MyWORID on 28.05.2017.
 */
public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public void init()
    {
        createNewDocument();
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void exit()
    {
        System.exit(0);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void resetDocument()
    {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener()); //Удалять у текущего document слушателя
        HTMLEditorKit kit = new HTMLEditorKit();
        document = (HTMLDocument) kit.createDefaultDocument(); //Создавать новый документ по умолчанию и присваивать его полю document.
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String string)
    /*будет записывать переданный текст с html тегами в документ document*/
    {
        try
        {
            resetDocument();  //Сбрось документ
            StringReader stringReader = new StringReader(string); //Создай новый реадер StringReader на базе переданного текста
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.read(stringReader, document, 0);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText()
    /*должен получать текст из документа со всеми html тегами*/
    {
        StringWriter writer = new StringWriter();
        try
        {
            //Перепиши все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument()
    /*пункт меню Файл --> Новый*/
    {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument()
    /*Метод должен работать аналогично методу saveDocumentAs(), в той части, которая отвечает за выбор файла*/
    {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser(); //Создавать новый объект для выбора файла JFileChooser
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter); //Устанавливать ему в качестве фильтра объект HTMLFileFilter
        int returnVal = jFileChooser.showOpenDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            currentFile = jFileChooser.getSelectedFile(); //Установить новое значение currentFile
            resetDocument(); //Сбросить документ
            view.setTitle(currentFile.getName()); // Установить имя файла в заголовок у представления
            try (FileReader fileReader = new FileReader(currentFile)) // Создать FileReader, используя currentFile
            {
                new HTMLEditorKit().read(fileReader, document, 0);
                /*Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit*/
            }
            catch (FileNotFoundException e)
            {
                ExceptionHandler.log(e);
            }
            catch (IOException e)
            {
                ExceptionHandler.log(e);
            }
            catch (BadLocationException e)
            {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument()
    /*Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а
    использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().*/
    {
        view.selectHtmlTab();
        if (currentFile == null)
        {
            saveDocumentAs();
        } else
        {
            try (FileWriter writer = new FileWriter(currentFile)) //Создавать FileWriter на базе currentFile
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());  /*Переписывать данные из document
                в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()*/
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs()
    {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser(); //Создавать новый объект для выбора файла JFileChooser
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter); //Устанавливать ему в качестве фильтра объект HTMLFileFilter

        int returnVal = jFileChooser.showSaveDialog(view);
        //Показывать диалоговое окно "Save File" для выбора файла (цей метод автоматично показує Save File

        if (returnVal == JFileChooser.APPROVE_OPTION)
        { //Если пользователь подтвердит выбор файла
            currentFile = jFileChooser.getSelectedFile(); //Сохранять выбранный файл в поле currentFile
            view.setTitle(currentFile.getName()); //Устанавливать имя файла в качестве заголовка окна представления
            try (FileWriter writer = new FileWriter(currentFile)) //Создавать FileWriter на базе currentFile
            {
                new HTMLEditorKit().write(writer, document, 0, document.getLength());  /*Переписывать данные из document
                в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()*/
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }
}
