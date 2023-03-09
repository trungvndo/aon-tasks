package com.trungdo.task1;

/**
 * A wrapper class that implements IncDec
 * It delegates the method call to IncDec implementation (i.e MyIncDec)
 * It measures method invocation time for each method using Metrics class
 */
public class TimedIncDec implements IncDec {

    private IncDec incDecImp;
    private Metrics metrics;

    public TimedIncDec(IncDec incDecImp) {
        this.incDecImp = incDecImp;
        this.metrics = new Metrics(incDecImp.getClass().getName());
    }

    @Override
    public void increment() {

        metrics.start();
        this.incDecImp.increment();
        metrics.stop();
    }

    @Override
    public void decrement() {
        metrics.start();
        this.incDecImp.decrement();
        metrics.stop();
    }
}
