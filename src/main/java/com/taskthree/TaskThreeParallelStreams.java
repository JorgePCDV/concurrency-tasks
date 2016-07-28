package com.taskthree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskThreeParallelStreams {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");


        long sum = Stream.of(arr).parallel()
                .mapToInt(Integer::parseInt)
                .map(val -> calculateFactorial(val))
                .sum();


        System.out.println("Factorial sum " + sum);

    }

    public static int calculateFactorial(int base) {
        int factorial = 1;

        factorial = IntStream.rangeClosed(factorial, base)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial of " + base + " is " + factorial);
        return factorial;
    }
}
