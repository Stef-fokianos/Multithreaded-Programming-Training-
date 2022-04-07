/*
 *
 *  task11.java
 *
 *  creates 2 threads from different classes
 *
 *
 */


import java.util.Scanner;

public class task11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        /*number of threads*/
        int numThreads = 2;
        Thread[] threads = new Thread[numThreads];

        /*get user input for type of thread*/
        for (int i=0; i < numThreads ; i++)
        {
            System.out.println("Enter a thread type : ");
            int Type = input.nextInt();

             /*Create and start threads based on their type*/
             System.out.println("Type" + Type + " Thread created number " + i + "thread");
             if (Type == 1) {
                 threads[i] = new type1Thread();
             }
             else if (Type == 2 ){
                 threads[i] = new type2Thread();
            }
            else {
                    System.out.println("Not a valid Thread type.");
            }

            threads[i].start();
      
        }

        /*wait for threads to finish*/
        for (int i=0; i<numThreads; i++)
        {
            try{
                threads[i].join();
            }
            catch (InterruptedException e ){
                System.out.println("Error");

            }
        }

        System.out.println("Main is ok");


    }

}

class type1Thread extends Thread
{
    /* This is the first type of thread*/
    public void run() {
        System.out.println("Type 1 thread - Thread number " + Thread.currentThread().getName());
    }

}    


class type2Thread extends Thread
{
    /* This is the first type of thread*/
    public void run() {
        System.out.println("Type 2 thread - Thread number " + Thread.currentThread().getName());
    }

}
