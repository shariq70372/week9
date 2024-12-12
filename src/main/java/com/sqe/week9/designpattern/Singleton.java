package com.sqe.week9.designpattern;

/**
 * The Singleton Pattern ensures that a class has only one
 * instance and provides a global point of access to it.
 *
 * Purpose: Useful when exactly one object is needed to coordinate
 * actions across a system (e.g., a database connection, a configuration manager).
 *
 * Implementation:
 * Make the constructor private.
 * Use a static variable to hold the single instance.
 * Provide a public static method to access the instance.
 */
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

