package Threads.Shared_Variables;
class Task1 implements Runnable{
    int count=0;
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            count=count+1;
        }
    }
    public int getCount(){
        return this.count;
    }
}
public class SharedVariables_1 {
    public static void main(String[] args) {
        Task1 task1=new Task1();
        Thread t1=new Thread(task1);
        Thread t2=new Thread(task1);
        Thread t3=new Thread(task1);
        Thread t4=new Thread(task1);
        t4.start();
        t3.start();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (Exception e){

        }
        System.out.println("Expected Value : "+40000);
        System.out.println("Current Value : "+task1.getCount());
    }
}
