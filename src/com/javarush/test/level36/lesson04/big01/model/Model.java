package com.javarush.test.level36.lesson04.big01.model;

public interface Model
{
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
}
