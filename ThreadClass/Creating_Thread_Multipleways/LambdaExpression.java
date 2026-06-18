package Threads.ThreadClass.Creating_Thread_Multipleways;

public class LambdaExpression { // metaspace
    public static void main(String[] args) { // main activation record in stack is created
        System.out.println("Main Started......");
        /*  Recipe
            ->recipe is a small object that have 2 parameters
            ->Those parameter are a pointer that point to some lambda expression and another is for variable
        */
        Thread t1=new Thread(()->{ // new Thread() created in heap which is takes recipe as argument and t1 pointer in main stack
            // line 8,line 9 and line 10 (code inside lambda expression)are created in metaspace privately in class lambdaexpression(parent class)
            // In runtime in heap there would be small size recipe will be created which will point to private metaspace
            System.out.println(Thread.currentThread().getName()+" Started ....."); //line 8
            System.out.println(Thread.currentThread().getName()+" I have a different recipe");
            System.out.println(Thread.currentThread().getName()+" Terminated ....."); //line 10
        });

        //Lambda expression will have a different private metaspace and a new different recipe
        Thread t2=new Thread(()->{ //in heap
            System.out.println(Thread.currentThread().getName()+" Started .....");
            System.out.println(Thread.currentThread().getName()+" I have a different recipe");
            System.out.println(Thread.currentThread().getName()+" Terminated .....");
        });

        //Lambda expression will have a different private metaspace and a new different recipe
        Thread t3=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" Started .....");
            System.out.println(Thread.currentThread().getName()+" I have a different recipe");
            System.out.println(Thread.currentThread().getName()+" Terminated .....");
        });


        /*  start() method
           -> when start is called it goes to kernel and request a new thread
           ->After a successful allocation of new thread a private stack is created then the recipe pointing metaspace will be pushed into this memory area
           ->Execution of the lambda expression is started
        */
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main Terminated.....");
    }
}
