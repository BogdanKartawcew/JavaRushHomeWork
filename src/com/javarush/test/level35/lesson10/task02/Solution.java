package com.javarush.test.level35.lesson10.task02;

import java.util.List;

/* extends vs super
Логика всех методов - добавить source в destination.
!!!Расставьте ?, extends и super где необходимо:!!!

extends - наследник
super - родительский

1) one - должен работать с одним и тем же типом;

2) two - должен добавлять любых extends типа T в список, умеющий хранить только тип T;

3) three - должен добавлять объекты типа T в любой список, параметризированный любым super классом;

4) four - должен добавлять любых extends типа T в список, параметризированный любым super классом.
Не оставляйте закомментированный код.
*/
public abstract class Solution {
    public abstract <T> void one(List<T> destination, List<T> source);

    public abstract <T> void two(List<T> destination, List<? extends T> source);

    public abstract <T> void three(List<? super T> destination, List<T> source);

    public abstract <T> void four(List<? super T> destination, List<? extends T> source);
}
