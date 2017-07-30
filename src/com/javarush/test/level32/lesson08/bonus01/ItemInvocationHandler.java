package com.javarush.test.level32.lesson08.bonus01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ItemInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("і тут ти можеш робити свою реалізацію");
        return null;
    }
}
