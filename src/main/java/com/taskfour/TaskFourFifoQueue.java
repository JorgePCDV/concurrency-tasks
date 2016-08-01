package com.taskfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// TODO: two semaphores, one for empty one for full
public class TaskFourFifoQueue {

    public static class FIFOQueue {
        private List<Double> queue;
        private int numberOfElements;
        final Semaphore semaphorePut = new Semaphore(1, true);
        final Semaphore semaphoreGet = new Semaphore(0, true);

        public FIFOQueue(int numberOfElements) {
            this.queue = new ArrayList<>();
            this.numberOfElements = numberOfElements;
        }

        public void put(double putValue) throws IndexOutOfBoundsException, InterruptedException {
            try {
                semaphorePut.acquire();
                while (queue.size() >= numberOfElements) {
                    System.out.println("Queue reached maximum size of " + numberOfElements + " elements");
                }
            } finally {
                semaphorePut.release();
            }

            try {
                semaphorePut.acquire();
                queue.add(putValue);
            } finally {
                semaphoreGet.release();
            }

            /*final Lock lock = this.lock;
            synchronized (lock) {
                while (queue.size() >= numberOfElements) {
                    System.out.println("Queue reached maximum size of " + numberOfElements + " elements");
                    lock.wait();
                }
            }
            synchronized (lock) {
                queue.add(putValue);
                lock.notifyAll();
            }*/
        }

        public double get() throws Exception {
            double outNumber;

            try {
                semaphoreGet.acquire();
                while (queue.isEmpty()) {
                    System.out.println("Queue currently empty");
                }
            } finally {
                semaphoreGet.release();
            }

            try {
                semaphoreGet.acquire();
                outNumber = queue.get(0);
                queue.remove(0);
            } finally {
                semaphorePut.release();
            }

            return outNumber;

            /*double outNumber;
            final Lock lock = this.lock;
            synchronized (lock) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue currently empty");
                        lock.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (lock) {
                outNumber = queue.get(0);
                queue.remove(0);
                lock.notifyAll();
            }
            return outNumber;*/
        }
    }

    public static FIFOQueue myQueue = new FIFOQueue(10);

    public static class Producer implements Runnable {
        int counter = 1;

        public void run() {
            while (true) {
                double number = counter++;
                try {
                    myQueue.put(number);
                    Thread.sleep((long)(Math.random() * 10));
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
                    Double number = myQueue.get();
                    System.out.println("Consumed number: " + number);
                    Thread.sleep((long)(Math.random() * 10));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }
}
