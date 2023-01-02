package com.seriousarch.designpattern.creational.prototype;

import com.seriousarch.designpattern.creational.prototype.cache.BundledShapeCache;
import com.seriousarch.designpattern.creational.prototype.shapes.Circle;
import com.seriousarch.designpattern.creational.prototype.shapes.Rectangle;
import com.seriousarch.designpattern.creational.prototype.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.color = "red";
        circle.radius = 15;
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        for (Shape shape: shapes) {
            shapesCopy.add(shape.clone());
        }
        cloneAndCompare(shapes, shapesCopy);

        BundledShapeCache cache = new BundledShapeCache();
        Shape shape1 = cache.get("Big green circle");
        Shape shape2 = cache.get("Medium blue rectangle");
        Shape shape3 = cache.get("Medium blue rectangle");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Big green circle != Medium blue rectangle");
        } else {
            System.out.println("Big green circle == Medium blue rectangle");
        }

        if (shape2 != shape3) {
            System.out.println("Medium blue rectangles are two different objects");
            if (shape2.equals(shape3)) {
                System.out.println("and they are identical");
            } else {
                System.out.println("but they are not identical");
            }
        } else {
            System.out.println("rectangle objects are the same");
        }
    }


    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": and they are identical");
                } else {
                    System.out.println(i + ": but they are not identical");
                }
            } else {
                System.out.println(i + ": shape objects are the same");
            }
        }
    }
}
