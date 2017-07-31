package com.javarush.test.level35.lesson04.home01;

public class GenericStatic {
    /*public static <Object> Object someStaticMethod(Object genericObject) {

        System.out.println(genericObject);
        return genericObject;
    }*/ // - це пройшло і це повністю мій варіант.

    /*public static Object someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }*/ // - таким був оригінал

    public static <Object> Object someStaticMethod(Object genericObject) {

        System.out.println(genericObject.getClass().getSimpleName());
        return genericObject;
    }

}
