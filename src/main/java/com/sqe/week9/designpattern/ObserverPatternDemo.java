package com.sqe.week9.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer Pattern defines a one-to-many dependency where
 * multiple observers listen for and react to state changes in a subject.
 *
 * Purpose: Useful for implementing distributed event-handling systems
 * (e.g., a notification system, GUI event listeners).
 *
 * Key Components:
 * Subject: Maintains a list of observers and notifies them of changes.
 * Observer: Receives updates from the subject.
 */
interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Usage
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer obs1 = new ConcreteObserver("Observer 1");
        Observer obs2 = new ConcreteObserver("Observer 2");

        subject.attach(obs1);
        subject.attach(obs2);

        subject.notifyObservers("Event occurred!");
    }
}

