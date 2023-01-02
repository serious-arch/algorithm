package com.seriousarch.designpattern.creational.prototype.shapes;

import java.util.Objects;

/**
 * 通用形状接口
 */
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {
    }

    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object2) {
        if (this == object2) return true;
        if (object2 == null || getClass() != object2.getClass()) return false;
        Shape shape2 = (Shape) object2;
        return x == shape2.x && y == shape2.y && Objects.equals(color, shape2.color);
    }

}
