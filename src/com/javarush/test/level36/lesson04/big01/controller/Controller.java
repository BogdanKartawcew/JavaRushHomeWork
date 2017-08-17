package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

public class Controller
{
    private UsersView usersView;
    private Model model;

    public void setEditUserView(EditUserView editUserView)
    {
        this.editUserView = editUserView;
    }

    private EditUserView editUserView;

    public void onShowAllUsers()
    {
        model.loadUsers();
        usersView.refresh(model.getModelData()); //Пойди в контроллер и добавь обновление данных во Вью.
    }

    public void onShowAllDeletedUsers()
    {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }



    public void setUsersView(UsersView usersView)
    {
        this.usersView = usersView;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }
}
