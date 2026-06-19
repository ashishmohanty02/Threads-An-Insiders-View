package Threads.Runnable.Custom_Methods.NonStatic_Methods;
class Task implements Runnable{
    private NonStatic_Methods nonStaticMethods;
    int n;
    Task(NonStatic_Methods nonStaticMethods,int n){
        this.nonStaticMethods=nonStaticMethods;
        this.n=n;
    }
    @Override
    public void run() {
        nonStaticMethods.nonStatic_Method(n);
    }
}
public class NonStatic_Methods {
    public static void main(String[] args) {
        NonStatic_Methods nonStaticMethods=new NonStatic_Methods();
        Task task1=new Task(nonStaticMethods,10);
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task1);
        t1.start();
        t2.start();
    }
    public static void nonStatic_Method(int n){
        for (int i=0;i<n;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}
