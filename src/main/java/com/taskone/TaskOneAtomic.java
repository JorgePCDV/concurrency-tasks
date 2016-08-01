package com.taskone;

import java.util.concurrent.atomic.AtomicInteger;


public class TaskOneAtomic {
    public static AtomicInteger value = new AtomicInteger(0);
    public static final int ITERATIONS = 10;

    Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println("AddOne thread started");
                int val = value.addAndGet(1);
                System.out.println("Value is now: " + val);
            }
        }
    };

    Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println("AddOne thread started");
                int val = value.addAndGet(-1);
                System.out.println("Value is now: " + val);
            }
        }
    };

    Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println("Add seven thread started");
                int val = value.addAndGet(7);
                System.out.println("Value is now: " + val);
            }
        }
    };

    public static void main(String[] args) {
        TaskOneAtomic taskOneAtomic = new TaskOneAtomic();
        taskOneAtomic.init();
    }

    public void init() {
        addOne.start();
        substractOne.start();
        addSeven.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Value " + value.get());
    }
}
