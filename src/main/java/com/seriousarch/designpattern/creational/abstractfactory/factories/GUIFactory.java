package com.seriousarch.designpattern.creational.abstractfactory.factories;

import com.seriousarch.designpattern.creational.abstractfactory.checkbox.Checkbox;
import com.seriousarch.designpattern.creational.abstractfactory.button.Button;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
