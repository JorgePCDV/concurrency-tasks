package com.taskfour;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/*public class TaskFourFifoQueue extends Queue {
    Queue myQueue;

    public Queue TaskFourFifoQueue(Integer elements) {
        this.myQueue = new SynchronousQueue(elements);
    }

    TaskFourFifoQueue myQueue = new TaskFourFifoQueue(10);

    public static class Producer implements Runnable {
        public void run() {
            while (true) {
                Double number = Math.random();
                myQueue.put(number);
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}*/
