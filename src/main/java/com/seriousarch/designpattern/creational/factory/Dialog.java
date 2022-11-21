package com.seriousarch.designpattern.creational.factory;

/**
 * 基础创建者
 */
public abstract class Dialog {
    public void renderWindow() {
        // ... other code ...
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();

}
