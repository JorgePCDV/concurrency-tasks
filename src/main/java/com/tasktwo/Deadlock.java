package com.tasktwo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Deadlock {
    //TODO: Use locks one for each resource

    String str1 = "First";
    Integer counter = 0;
    Lock lock = new ReentrantLock();

    public void increaseCounter() {
        synchronized (counter) {
            counter++;
        }
    }

    Thread trd1 = new Thread("My Thread 1") {
        public  void run() {
            while (true) {
                try {
                    increaseCounter();
                    System.out.println(str1 + " " + counter);
                    synchronized (str1) {
                        str1 = "Previous My Thread 1";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2") {
        public void run() {
            while (true) {
                try {
                    increaseCounter();
                    System.out.println(str1 + " " + counter);
                    synchronized (str1) {
                        str1 = "Previous My Thread 2";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String a[]) {
        Deadlock mdl = new Deadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
