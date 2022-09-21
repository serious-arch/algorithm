package com.seriousarch.designpattern;

/**
 * 单例模式
 * 线程安全的懒汉式：静态内部类
 */
public class Singleton {
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Singleton() {}

}
