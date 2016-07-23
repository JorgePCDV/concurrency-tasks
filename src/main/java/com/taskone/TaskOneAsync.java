package com.taskone;

public class TaskOneAsync {
    public static Integer value = 0;
    public int iterations = 10;

    Thread addOne = new Thread("Add One") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                value += 1;
                System.out.println("Value is now: " + value.toString());
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread substractOne = new Thread("Substract one") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("AddOne thread started");
                value -= 1;
                System.out.println("Value is now: " + value.toString());
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread addSeven = new Thread("Add seven") {
        public void run() {
            for (int i = 0; i <= iterations; i++) {
                System.out.println("Add seven thread started");
                value += 7;
                System.out.println("Value is now: " + value.toString());
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        TaskOneAsync taskOneAsync = new TaskOneAsync();
        taskOneAsync.addOne.start();
        taskOneAsync.substractOne.start();
        taskOneAsync.addSeven.start();
    }
}
