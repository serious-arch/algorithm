package com.seriousarch.designpattern.creational.factory;

/**
 * 另一个具体创建者
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
