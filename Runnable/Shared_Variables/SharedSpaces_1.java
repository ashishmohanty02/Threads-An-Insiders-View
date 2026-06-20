package Threads.Runnable.Shared_Variables;

class SharedVar{
    int data=0;

}
class Task implements Runnable{
    private SharedVar sharedVar;
    Task(SharedVar sharedVar){
        this.sharedVar=sharedVar;
    }
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            sharedVar.data++;
        }
    }
    public int getData(){
        return sharedVar.data;
    }
}
public class SharedSpaces_1 {
    public static void main(String[] args) {
        SharedVar sharedVar=new SharedVar();
        Task task=new Task(sharedVar);
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
//        System.out.println(task.getData());
        System.out.println(sharedVar.data);

    }



}
