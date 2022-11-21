package com.seriousarch.designpattern.creational.factory;

/**
 * 具体产品
 */
public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Html Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
