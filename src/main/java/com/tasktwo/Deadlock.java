package com.tasktwo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    String str1 = "First";
    int counter = 0;
    Lock lock = new ReentrantLock();

    Thread trd1 = new Thread("My Thread 1") {
        public synchronized void run() {
            while (true) {
                try {
                    if (counter % 2 != 0) {
                        lock.lock();
                        System.out.println(str1 + " " + counter++);
                        str1 = "Previous My Thread 1";
                        lock.unlock();
                    } else {
                        sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    };

    Thread trd2 = new Thread("My Thread 2") {
        public synchronized void run() {
            while (true) {
                try {
                    if (counter % 2 == 0) {
                        lock.lock();
                        System.out.println(str1 + " " + counter++);
                        str1 = "Previous My Thread 2";
                        lock.unlock();
                    } else {
                        sleep(10);
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
