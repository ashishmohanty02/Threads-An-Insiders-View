package Threads.Runnable.Creating_Runnable_MultipleWays;

class Task1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Started....");
        System.out.println(Thread.currentThread().getName()+" Terminated....");
    }
}
public class MyRunnable {
    public static void main(String[] args) {
        Task1 task1=new Task1();
        // same object is passed into different threads
        // if we create a variable then it will be shared variable in between them and will create inconsistency
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task1);
        // same as Thread class,creating new class obj everytime assign different it to threads
        Task1 task2=new Task1();
        Task1 task3=new Task1();
        Thread t3=new Thread(task2);
        Thread t4=new Thread(task3);

        //
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
