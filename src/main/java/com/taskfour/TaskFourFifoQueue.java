package com.taskfour;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class TaskFourFifoQueue {

    public static class FIFOQueue {
        private List<Double> queue;
        private int numberOfElements;

        public FIFOQueue(int numberOfElements) {
            this.queue = new ArrayList<>();
            this.numberOfElements = numberOfElements;
        }

       public synchronized void put(double putValue) throws IndexOutOfBoundsException, InterruptedException {
           if (queue.size() >= numberOfElements) {
               sleep(50);
           } else {
               queue.add(putValue);
           }
       }

       public synchronized double get() throws Exception {
           if (queue.isEmpty()) {
               System.out.println("Queue currently empty");
               sleep(50);
           }
           double outNumber = queue.get(0);
           queue.remove(0);
           return outNumber;
       }
    }

    public static FIFOQueue myQueue = new FIFOQueue(10);

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
                    Double number = myQueue.get();
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
    }
}
