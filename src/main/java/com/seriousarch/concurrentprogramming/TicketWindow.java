package com.seriousarch.concurrentprogramming;

public class TicketWindow implements Runnable {
    // 最多受理50笔业务
    private static final int MAX = 50;

    private int index = 1;

    @Override
    public void run() {
        synchronized (TicketWindow.class) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + " 当前的号码是: " + (index++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketWindow task = new TicketWindow();
        Thread ticketWindow1 = new Thread(task, "一号");
        ticketWindow1.start();

        Thread ticketWindow2 = new Thread(task, "二号");
        ticketWindow2.start();

        Thread ticketWindow3 = new Thread(task, "三号");
        ticketWindow3.start();

        Thread ticketWindow4 = new Thread(task, "四号");
        ticketWindow4.start();
    }
}
