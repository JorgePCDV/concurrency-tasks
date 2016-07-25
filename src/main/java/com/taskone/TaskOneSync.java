package com.taskone;

public class TaskOneSync {
    public static Integer value = 0;
    public int iterations = 10;

    public synchronized void add(Integer value) {
        this.value += value;
    }

    Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                add(1);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                add(-1);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("Add seven thread started");
                add(7);
                System.out.println("Value is now: " + value.toString());
            }
        }
    };

    public static void main(String[] args) {
        TaskOneSync taskOneSync = new TaskOneSync();
        taskOneSync.addOne.start();
        taskOneSync.substractOne.start();
        taskOneSync.addSeven.start();
    }
}
