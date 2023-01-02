package com.seriousarch.designpattern.creational.singleton;

/**
 * 双检锁（DCL, double-checked locking）单例模式
 */
public final class Singleton {
    private volatile static Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    private Singleton() {}

    public static Singleton getInstance(String value) {
        // 线程1，2同时到达，均通过（instance == null）判断
        if (instance == null) {
            // 线程1执行发现instance为null，初始化实例后，释放锁
            // 线程2进入同步块，此次instance已经被初始化。无法通过if条件，避免多次重复初始化
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }

}
