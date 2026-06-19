package Threads.ThreadClass.Creating_Thread_Multipleways;

class ThreadTask1 extends Thread{ // going to created in metaspace
    int counter=0;
    @Override
    public void run() {
        counter++;
        System.out.println(Thread.currentThread().getName()+" "+counter);
    }
}

public class Mythread1 { // meta space
    public static void main(String[] args) { // shared stack and activation recored with name "main" is created
        System.out.println("Main thread started ....");
        ThreadTask1 t1=new ThreadTask1(); // new ThreadTask1() in common shared heap(e.g 2k memory address) and t1 in main stack pointing to 2k
        ThreadTask1 t2=new ThreadTask1(); //new ThreadTask2() in common shared heap(e.g 8k memory address) and t2 in main stack pointing to 8k
        t1.start(); // allocation of new private stack and loading of start method as activation recored with address 12k
        t2.start(); // allocation of new private stack and loading of start method as activation recored with address 98k
        ThreadTask1 t3=new ThreadTask1();
        Thread t4=new Thread(t3);
        Thread t5=new Thread(t3);
        t4.start();
        t5.start();
        System.out.println("Main thread completed its execution");
    }
}
