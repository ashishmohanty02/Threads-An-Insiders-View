package Threads.Runnable.Creating_Runnable_MultipleWays;

public class LambdaExpression {
    public static void main(String[] args) {
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+" Started....");
            System.out.println(Thread.currentThread().getName()+" Terminated");
        };
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
    }
}
