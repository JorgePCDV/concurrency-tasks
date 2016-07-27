package com.taskthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskThreeExecutors {
    public static long sum = 0;

    public static void main(String args[]) throws Exception {
        long sum = 0;
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = new ArrayList<Integer>();
        //TODO: Does not do sum of numbers correctly
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        ExecutorService executor = Executors.newFixedThreadPool(list.size());
        for (Integer number : list) {
            executor.submit(new FactorialThread(number));

        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Sum of all factorials is: " + TaskThreeExecutors.sum);
        System.out.println("Executor terminated");
    }

    public static class FactorialThread implements Callable<Integer> {
        private Integer base;
        private Integer factorial;


        public FactorialThread(Integer f) {
            this.base = f;
            this.factorial = f;
        }

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " starting factorial " + this.factorial);
            Integer result = calculateFactorial();
            long value = TaskThreeExecutors.sum;
            try {
                Thread.sleep(new Random().nextInt(100));
                TaskThreeExecutors.sum = value + result;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ended calculating " + result);
            return result;
        }

        public Integer calculateFactorial() {
            try {
                Thread.sleep(300);
                if (factorial < 0) {
                    System.out.println("Negative numbers not allowed");
                } else {
                    for (int j = base - 1; j >= 1; j--) {
                        factorial *= j;
                    }
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Factorial of " + base + " is " + factorial);
            return factorial;
        }

    }
}
