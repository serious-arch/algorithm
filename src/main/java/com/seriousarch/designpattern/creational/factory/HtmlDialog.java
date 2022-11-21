package com.seriousarch.designpattern.creational.factory;

/**
 * 具体创建者
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
