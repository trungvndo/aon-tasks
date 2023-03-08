package com.trungdo.task1;

public class TimedIncDecRunner {

    public static void main(String[] args) {
        IncDec incDec = new TimedIncDec(new MyIncDec(5));

        for (int i = 0; i < 5; i++) {
            incDec.increment();
            incDec.decrement();
        }
    }
}
