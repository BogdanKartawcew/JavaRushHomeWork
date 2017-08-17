package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;

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
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Bogdan", 1, 1));
        users.add(new User("Lera", 2, 1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId)
    {
        throw new UnsupportedOperationException();
    }

    private ModelData modelData = new ModelData();

}
