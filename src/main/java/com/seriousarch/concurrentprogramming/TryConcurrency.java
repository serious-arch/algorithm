package com.seriousarch.concurrentprogramming;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                browseNews();
            }
        }.start();

        enjoyMusic();
    }

    private static void enjoyMusic() {
        for (;;) {
            System.out.println("Uh-huh, nice music.");
            sleep(1);
        }
    }

    private static void browseNews() {
        for (;;){
            System.out.println("Uh-huh, good news.");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
