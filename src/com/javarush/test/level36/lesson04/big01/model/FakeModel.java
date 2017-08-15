package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model
{
    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        List<User> users = new ArrayList<>();
        users.add(new User("Bogdan", 1, 1));
        users.add(new User("Lera", 2, 1));
        modelData.setUsers(users);
    }

    private ModelData modelData = new ModelData();
}
