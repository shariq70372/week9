package com.sqe.week9.designpattern;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to restrict instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

