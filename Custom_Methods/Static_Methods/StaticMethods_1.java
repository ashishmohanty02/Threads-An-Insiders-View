package Threads.Custom_Methods.Static_Methods;
class Task1 implements Runnable{
    int n;
    Task1(){
        n=100;
    }
    Task1(int n){
        this.n=n;
    }
    @Override
    public void run() {
        StaticMethods_1.staticMethod_1(n);
    }
}
public class StaticMethods_1 {
    public static void main(String[] args) {
            Task1 obj=new Task1(5);
            Thread t1=new Thread(obj);
            t1.start();
    }
    public static void staticMethod_1(int n){
        for(int i=0;i<n;i++){
            System.out.println("staticMethod_1 : "+i);
        }
    }

}
