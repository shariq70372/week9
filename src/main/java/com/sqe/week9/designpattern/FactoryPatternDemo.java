package com.sqe.week9.designpattern;

/**
 * The Factory Pattern defines an interface or abstract class for
 * creating objects but lets subclasses or methods decide which class to instantiate.
 *
 * Purpose: Useful when the exact type of the object is not known
 * until runtime (e.g., creating shapes, database connections).
 *
 * Key Concepts:
 * Encapsulates object creation.
 * Promotes loose coupling by decoupling client code from specific implementations.
 */
interface Shape {
    void draw();
}

// Concrete Classes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Factory Class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// Usage
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = factory.getShape("RECTANGLE");
        shape2.draw();
    }
}

