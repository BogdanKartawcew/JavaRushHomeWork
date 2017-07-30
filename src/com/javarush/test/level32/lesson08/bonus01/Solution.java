package com.javarush.test.level32.lesson08.bonus01;

import java.lang.reflect.Proxy;

/* Дженерики для создания прокси-объекта
В классе Solution создайте публичный метод getProxy
1) Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item
2) getProxy должен иметь два параметра. Первый - класс возвращаемого типа, второй - классы дополнительных интерфейсов.
3) Используйте ItemInvocationHandler для создания прокси
Метод main не участвует в тестировании
*/
public class Solution
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    /*public <T extends Item> T getProxy(Class ...interfaces) {
        return (T) Proxy.newProxyInstance(interfaces[0].getClassLoader(), interfaces, new ItemInvocationHandler());
    }*/ //таке не проходить, хоч вивід співдпадає

    /*public <T extends Item> T getProxy(Class<T> itemClass, Class<?>... interfaces) {
        Class[] _interfaces = new Class[interfaces.length + 1];
        System.arraycopy(interfaces, 0, _interfaces, 0, interfaces.length);
        _interfaces[_interfaces.length - 1] = itemClass;
        return (T) Proxy.newProxyInstance(itemClass.getClassLoader(), _interfaces, new ItemInvocationHandler());
    }*/ // - пройшло з цим. але я хочу зрозуміти як це всьо працює

    public <T extends Item> T getProxy(Class<T> itemClass, Class... interfaces)
            /*Для указания аргумента переменной длины используют три точки (...). Например, вот как метод vaTest () можно записать с использованием аргумента Переменной длины:
static void vaTest(int ... v)
Эта синтаксическая конструкция указывает компилятору, что метод vaTest () может вызываться с нулем или более аргументов. В результате v неявно объявляется как массив типа int []*/

            //це також видає правильний результат
    {
        Class<?>[] interfacesArray = new Class[interfaces.length + 1];
        interfacesArray[0] = itemClass; // на перше місце кладемо itemClass
        for (int i = 0; i < interfaces.length; i++)
        {
            interfacesArray[i + 1] = interfaces[i]; //потім всі місця за ними заповнюємо інтерфейсами
        }
        return (T) Proxy.newProxyInstance(itemClass.getClassLoader(), //ClassLoader classLoader = itemClass.getClassLoader();
                interfacesArray, new ItemInvocationHandler());

        /*newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
Returns an instance of a proxy class for the specified interfaces that dispatches method invocations to the specified invocation handler.*/
    }

    private static void test(Object proxy)
    {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
