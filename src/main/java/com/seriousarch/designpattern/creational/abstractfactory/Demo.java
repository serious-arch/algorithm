package com.seriousarch.designpattern.creational.abstractfactory;

import com.seriousarch.App;
import com.seriousarch.designpattern.creational.abstractfactory.app.Application;
import com.seriousarch.designpattern.creational.abstractfactory.factories.GUIFactory;
import com.seriousarch.designpattern.creational.abstractfactory.factories.MacOSFactory;
import com.seriousarch.designpattern.creational.abstractfactory.factories.WindowsFactory;

public class Demo {
    public static Application configureApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
