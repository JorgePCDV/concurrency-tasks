package com.taskone;

import java.util.concurrent.CountDownLatch;

public class TaskOneSync {
    public static int value = 0;
    public int iterations = 100;

    public void add(Integer value) {
        synchronized (this) {
            this.value += value;
        }
    }

    Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                System.out.println("AddOne thread started");
                add(1);
                System.out.println("Value is now: " + value);
            }
        }
    };

    Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                System.out.println("AddOne thread started");
                add(-1);
                System.out.println("Value is now: " + value);
            }
        }
    };

    Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                System.out.println("Add seven thread started");
                add(7);
                System.out.println("Value is now: " + value);
            }
        }
    };

    public static void main(String[] args) {
        TaskOneSync taskOneSync = new TaskOneSync();
        taskOneSync.addOne.start();
        taskOneSync.substractOne.start();
        taskOneSync.addSeven.start();
    }
}
