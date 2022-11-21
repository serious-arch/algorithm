package com.seriousarch.designpattern.creational.abstractfactory.app;

import com.seriousarch.designpattern.creational.abstractfactory.button.Button;
import com.seriousarch.designpattern.creational.abstractfactory.checkbox.Checkbox;
import com.seriousarch.designpattern.creational.abstractfactory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
