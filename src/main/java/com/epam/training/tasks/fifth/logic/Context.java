package com.epam.training.tasks.fifth.logic;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();

    public double popValue() {
        return contextValues.pop();
    }
    public void pushValue(double value) {
        contextValues.push(value);
    }
}
