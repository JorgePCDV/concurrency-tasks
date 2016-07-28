package com.taskone;

import java.util.Random;

public class TaskOneAsync {
    public int value = 0;
    public int iterations = 10;

    public int increment(int value, int increment) throws InterruptedException {
        Thread.sleep(new Random().nextInt(20));
        value = value + increment;
        Thread.sleep(new Random().nextInt(5));
        return value;
    }

    public Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                try {
                    value = increment(value, 1);
                    System.out.println("1 thread value now: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                try {
                    value = increment(value, -1);
                    System.out.println("2 thread value now: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                try {
                    value = increment(value, 7);
                    System.out.println("3 thread value now: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        TaskOneAsync taskOneAsync = new TaskOneAsync();
        taskOneAsync.addOne.start();
        taskOneAsync.substractOne.start();
        taskOneAsync.addSeven.start();
    }
}
