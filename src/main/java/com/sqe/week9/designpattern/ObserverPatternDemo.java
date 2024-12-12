package com.sqe.week9.designpattern;

import java.util.ArrayList;
import java.util.List;

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

