package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyWORID on 26.02.2017.
 */
public class Hippodrome {
    public Hippodrome(){}
    private ArrayList<Horse> horses = new ArrayList<>();
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Diana", 3, 0));
        game.getHorses().add(new Horse("Olf", 3, 0));
        game.getHorses().add(new Horse("Rosalia", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException
    {
        for (int i=0; i<100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse metodmove : getHorses())
            metodmove.move();
    }
    public void print(){
        for (Horse metodprint : getHorses())
        {metodprint.print();}
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = new Horse("winner", 0,0);
        for (Horse winnerhorse:getHorses()){
            if (winnerhorse.getDistance()>winner.getDistance())
            {
                winner = winnerhorse;
            }

        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
