package com.trungdo.task1;

import java.util.Optional;

/**
 * Metrics class is used to measure method invocation time
 */
public class Metrics {

    private long startTime;

    /**
     * className of the method that is being measured
     */
    private String className;

    /**
     * method that is being measured
     */
    private String methodName;

    public Metrics(String className) {
        this.className = className;
    }

    public void start() {
        StackWalker stackWalker = StackWalker.getInstance();
        Optional<StackWalker.StackFrame> calledStackFrame = stackWalker.walk(frames -> frames
                .skip(1).findFirst()
        );
        calledStackFrame.ifPresent(stackFrame -> this.methodName = stackFrame.getMethodName());

        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.printf("Method %s of class %s took %d milliseconds%n", methodName, className, elapsedTime);
    }
}
