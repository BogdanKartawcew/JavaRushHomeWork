package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(byte a, int b, String ad)
    {
    }
    public static void printMatrix(short a, short b, String ad)
    {
    }
    public static void printMatrix(short a, byte b, String t )
    {
    }
    public static void printMatrix(byte b, short a, String ds)
    {
    }
    public static void printMatrix(int a, short b, String sa)
    {
    }
    public static void printMatrix(long a, long b, String df)
    {
    }
    public static void printMatrix(long a, int b, String tp)
    {
    }
    public static void printMatrix(int a, long b, String td)
    {}
}
