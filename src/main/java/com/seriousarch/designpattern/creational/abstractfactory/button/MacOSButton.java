package com.seriousarch.designpattern.creational.abstractfactory.button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
