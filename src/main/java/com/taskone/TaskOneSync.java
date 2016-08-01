package com.taskone;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class TaskOneSync {
    volatile public static int value = 0;
    public int iterations = 10;

    final Semaphore lock = new Semaphore(1, true);

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
                    lock.acquire();
                    value = increment(value, 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("1 thread value now: " + value);
                    lock.release();
                }
            }
        }
    };

    public Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                try {
                    lock.acquire();
                    value = increment(value, -1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("2 thread value now: " + value);
                    lock.release();
                }
            }
        }
    };

    public Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i < iterations; i++) {
                try {
                    lock.acquire();
                    value = increment(value, 7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("3 thread value now: " + value);
                    lock.release();
                }
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
