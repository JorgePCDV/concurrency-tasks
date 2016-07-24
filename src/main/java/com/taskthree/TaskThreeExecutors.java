package com.taskthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreeExecutors {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>();

        // TODO: Scanner not read the first integer
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        ExecutorService executor = Executors.newFixedThreadPool(list.size());
        for (Integer number : list) {
            Runnable factorialThread = new FactorialThread(number);
            executor.execute(factorialThread);
        }
        executor.shutdown();
        System.out.println("Executor terminated");
    }

    public static class FactorialThread implements Runnable {
        private Integer base;
        private Integer factorial;

        public FactorialThread(Integer f) {
            this.base = f;
            this.factorial = f;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starting factorial " + this.factorial);
            calculateFactorial();
            System.out.println(Thread.currentThread().getName() + " ended calculating " + this.factorial);
        }

        public void calculateFactorial() {
            try {
                Thread.sleep(300);
                if (factorial < 0) {
                    System.out.println("Negative numbers not allowed");
                } else {
                    for (int j = factorial - 1; j >= 1; j--) {
                        factorial *= j;
                    }
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Factorial of " + base + " is " + factorial);
        }
    }
}
