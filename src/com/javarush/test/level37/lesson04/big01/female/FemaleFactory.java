package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.Human;
import com.javarush.test.level37.lesson04.big01.male.KidBoy;
import com.javarush.test.level37.lesson04.big01.male.Man;
import com.javarush.test.level37.lesson04.big01.male.TeenBoy;

public class FemaleFactory
{
    public Human getPerson(int age)
    {
        if (age <= KidBoy.MAX_AGE)
            return new KidBoy();
        else if (age <= TeenBoy.MAX_AGE)
            return new TeenBoy();
        else return new Man();
    }
}
