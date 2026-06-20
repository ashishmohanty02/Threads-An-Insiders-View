package Threads.Shared_Variables;
class SharedVar2{
    int data=0;
}
class Task2 implements Runnable{
    private SharedSpace_2 sharedSpace2;
    private SharedVar2 sharedVar2;
    Task2(SharedSpace_2 sharedSpace2,SharedVar2 sharedVar2){
        this.sharedSpace2=sharedSpace2;
        this.sharedVar2=sharedVar2;
    }
    @Override
    public void run() {
        sharedSpace2.incr(sharedVar2);
    }
}
public class SharedSpace_2 {
    public static void main(String[] args) {
        SharedVar2 var=new SharedVar2();
        SharedSpace_2 sharedSpace2=new SharedSpace_2();
        Task2 task=new Task2(sharedSpace2,var);
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);
        Thread t4=new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (Exception e){

        }
        System.out.println(40000);
        System.out.println(var.data);

    }
    public void incr(SharedVar2 sharedVar2){
        for(int i=0;i<10000;i++){
            sharedVar2.data++;
        }
    }

}
