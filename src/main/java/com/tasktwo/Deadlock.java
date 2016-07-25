package com.tasktwo;

public class Deadlock {
    String str1 = "First";
    Integer counter =0;

    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(counter){
                        System.out.println(str1 +  " " + counter++);
                        str1="Previous My Thread 1";
                    }
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(counter){
                    synchronized(str1){
                        System.out.println(str1 + " " + counter++);
                        str1="Previous My Thread 2";
                    }
                }
            }
        }
    };

    public static void main(String a[]){
        Deadlock mdl = new Deadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
