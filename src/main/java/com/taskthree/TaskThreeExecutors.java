package com.taskthree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class TaskThreeExecutors {
    private Integer base;

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();

        for (int i=0; i < arr.length;i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        ExecutorService executor = Executors.newFixedThreadPool(list.size());
        List<Future> futures = new ArrayList();
        for (Integer number : list) {
            Future<Integer> future = executor.submit(new FactorialThread(number));
            futures.add(future);
        }
        executor.shutdown();

        long sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }

        System.out.println("Sum of all factorials is: " + sum);
        System.out.println("Executor terminated");
    }

    public static class FactorialThread implements Callable<Integer> {
        private Integer base;


        public FactorialThread(Integer f) {
            this.base = f;
        }

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " starting factorial " + this.base);
            int result = calculateFactorial(base);
            System.out.println(Thread.currentThread().getName() + String.format("calculated factorial for number=%s, result=%s", base, result));
            return result;
        }

        public int calculateFactorial(int base) {
            int factorial = 1;
            if (base < 0) {
                System.out.println("Negative numbers not allowed");
            } else {
                for (int j = 1; j <= base; j++) {
                    factorial *= j;
                }
            }
            System.out.println("Factorial of " + base + " is " + factorial);
            return factorial;
        }

    }
}
