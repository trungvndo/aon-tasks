package com.trungdo.task1;

import java.util.Random;

/**
 * MyIncDec class
 * Thread sleep is added to make method invocation time more visible
 */
public class MyIncDec implements IncDec {

    private int x;
    Random random = new Random();

    public MyIncDec(int x) {
        this.x = x;
    }

    @Override
    public void increment() {
        this.x++;
        try {
            Thread.sleep(random.nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrement() {
        this.x--;
        try {
            Thread.sleep(random.nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
