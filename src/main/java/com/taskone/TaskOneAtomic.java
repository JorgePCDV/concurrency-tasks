package com.taskone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class TaskOneAtomic {
    static AtomicInteger value = new AtomicInteger(0);
    public int iterations = 10;

    public void add(int delta) {
        value.addAndGet(delta);
    }

    Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                add(1);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                add(-1);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("Add seven thread started");
                add(7);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    public static void main(String[] args) {
        TaskOneAtomic taskOneAtomic = new TaskOneAtomic();
        taskOneAtomic.init();
    }

    private void init() {
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
