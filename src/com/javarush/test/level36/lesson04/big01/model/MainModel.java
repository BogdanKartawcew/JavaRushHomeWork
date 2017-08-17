package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model
{
    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setDisplayDeletedUserList(false);
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(users);
    }

    private ModelData modelData = new ModelData();


    private UserService userService = new UserServiceImpl();

    public void loadDeletedUsers()
    {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

    @Override
    public void loadUserById(long userId)
    {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
}
