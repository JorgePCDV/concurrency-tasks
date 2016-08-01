package com.taskfour;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class TaskFourJavaBlockingQueue {

    public static LinkedBlockingQueue<Double> myQueue = new LinkedBlockingQueue<>(10);

    public static class Producer implements Runnable {
        public void run() {
            while (true) {
                Double number = Math.random();
                try {
                    myQueue.put(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Produced number: " + number);
            }
        }
    }

    public static class Consumer implements Runnable {
        public void run() {
            while (true) {
                try {
                    Double number = myQueue.take();
                    System.out.println("Consumed number: " + number);
                    sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
