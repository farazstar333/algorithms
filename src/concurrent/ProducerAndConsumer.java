package concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


/**
 * Created by farazw808 on 8/16/15.
 * Idea is to simulate blocking queue behavior in java.
 * consumer will wait when there is no more item in queue.
 * producer will wait when queue is empty
 * I am using ArrayList to simulate the queue.
 */
public class ProducerAndConsumer {

     static int globalCounter=0;
    static int timer = 0; // stop after timer hits 100. just to limit this program

    public static void main(String args[]) {


        ArrayDeque arrayDeque = new ArrayDeque();
        Producer producer = new Producer(arrayDeque, 10);
        Consumer consumer = new Consumer(arrayDeque);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
        try{
        System.out.println("waiting for threads to finish");
        Thread.sleep(100000);
        }
        catch(Exception exp) {
            System.out.println(exp.toString());
        }

    }


}


class Producer implements Runnable {

    Queue sharedQueue;

    int maxSize;
    public Producer(Queue queue, int count) {
        sharedQueue = queue;
        this.maxSize = count;
    }


    /**
     * work horse for producer.
     */
    public void run() {
        System.out.println("before true in producer ");

        while (true ||  ProducerAndConsumer.timer < 1000 ) {

            //first get lock on sharedQueue
            synchronized (sharedQueue) {
                System.out.println("getting lock by producer ");
                try {
                    if (maxSize == ProducerAndConsumer.globalCounter) {
                        System.out.println("Queue is full. Need to wait until consumer consumes items.");
                        sharedQueue.wait();
                    }
                } catch (InterruptedException exp) {
                    System.out.println("Interrupted exception " + exp.toString());
                }

            }

            // now it means we can produce elements as queue as there

            synchronized (sharedQueue) {
                sharedQueue.add(Math.random());  // adding random number.
                System.out.println("added new item in queue counter is" + ++ProducerAndConsumer.globalCounter);
                ProducerAndConsumer.timer++;
                sharedQueue.notifyAll();  // notify all threads about new item and

            }


        }


    }

}


class Consumer implements Runnable {

    Queue sharedQueue;

    public Consumer(Queue queue) {
        sharedQueue = queue;

    }


    /**
     * work horse for producer.
     */
    public void run() {


        System.out.println("before true in consumer ");
        while (true) {

            //first get lock on sharedQueue
            synchronized (sharedQueue) {
                System.out.println("getting lock by consumer ");
                try {
                    if (sharedQueue.isEmpty()) {
                        System.out.println("Queue is empty. Need to wait until producer produces items.");
                        sharedQueue.wait();
                    }
                } catch (InterruptedException exp) {
                    System.out.println("Interrupted exception " + exp.toString());
                }

            }

            // now it means we can produce elements as queue as there

            synchronized (sharedQueue) {


                System.out.println(sharedQueue.poll());
                System.out.println(" consumed from pool decreasing counter to " + --ProducerAndConsumer.globalCounter);


                sharedQueue.notifyAll();  // notify all threads about new item and

            }


        }


    }

}
