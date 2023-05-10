package com.contest.greencode.atm.dto;

public enum AtmRequestType {
    FAILURE_RESTART(0),
    PRIORITY(1),
    SIGNAL_LOW(2),
    STANDARD(3);

    private final int priority;

    AtmRequestType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
