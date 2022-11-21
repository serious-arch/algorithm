package com.seriousarch.designpattern.creational.abstractfactory.factories;

import com.seriousarch.designpattern.creational.abstractfactory.button.Button;
import com.seriousarch.designpattern.creational.abstractfactory.button.MacOSButton;
import com.seriousarch.designpattern.creational.abstractfactory.checkbox.Checkbox;
import com.seriousarch.designpattern.creational.abstractfactory.checkbox.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
