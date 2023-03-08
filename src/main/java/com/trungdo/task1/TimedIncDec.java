package com.trungdo.task1;

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
