package com.seriousarch.designpattern.creational.abstractfactory.factories;

import com.seriousarch.designpattern.creational.abstractfactory.button.Button;
import com.seriousarch.designpattern.creational.abstractfactory.button.WindowsButton;
import com.seriousarch.designpattern.creational.abstractfactory.checkbox.Checkbox;
import com.seriousarch.designpattern.creational.abstractfactory.checkbox.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
