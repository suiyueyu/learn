package me.yzcc.learn.leetcode.interview;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());

        Runnable runnable = () -> {
            while (true) ;
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        try {
            for (Thread thread :threads) {
                    thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    Object
}
