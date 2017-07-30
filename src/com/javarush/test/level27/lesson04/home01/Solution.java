package com.javarush.test.level27.lesson04.home01;

/* Модификаторы и дедлоки
Расставьте модификаторы так, чтобы при работе с этим кодом появился дедлок
*/
public class Solution {
    private synchronized Object getData() {
        return new ThreadDeadlock().getData();
    } // а тут додав синхро і паблік поміняв на пріват
}
