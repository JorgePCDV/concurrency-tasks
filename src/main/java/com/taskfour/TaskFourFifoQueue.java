package com.taskfour;

import java.util.ArrayList;
import java.util.List;

public class TaskFourFifoQueue {

    public static class FIFOQueue {
        private List<Double> queue;
        private int numberOfElements;

        public FIFOQueue(int numberOfElements) {
            this.queue = new ArrayList<>();
            this.numberOfElements = numberOfElements;
        }

       public synchronized void put(double putValue) throws IndexOutOfBoundsException {
           if (queue.size() >= numberOfElements) {
               throw new IndexOutOfBoundsException("Queue does not allow more than " + numberOfElements + " elements");
           } else {
               queue.add(putValue);
           }
       }

       public synchronized double get() throws Exception {
           if (queue.isEmpty()) {
               throw new Exception("No elements in queue");
           }

           double firstOutNumber = queue.get(0);

           return firstOutNumber;
       }
    }

    public static FIFOQueue myQueue = new FIFOQueue(10);

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
