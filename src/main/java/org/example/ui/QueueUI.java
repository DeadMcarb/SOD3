package org.example.ui;

import org.example.data.MyPriorityQueue;

import java.util.Random;
import java.util.Scanner;

public class QueueUI {

    private void menu(){
        System.out.println("[1] Add");
        System.out.println("[2] Remove");
        System.out.println("[3] Print queue");
        System.out.println("[4] Clear queue");
        System.out.println("[5] Go Back");
    }

    public void runQueueUI(Scanner sc, MyPriorityQueue queue) {

        loop:
        while (true){
            menu();
            int m = sc.nextInt();
            switch (m) {
                case 1 -> {
                    addNum(sc, queue);
                    System.out.println("Successfully added");
                }
                case 2 -> {
                    queue.dequeue();
                    System.out.println("Successfully removed");
                }
                case 3 -> System.out.println(queue.toString());
                case 4 -> {
                    queue.clear();
                    System.out.println("Now queue is empty");
                }
                case 5 -> {break loop;}
            }
        }
    }

    private void addNum(Scanner sc, MyPriorityQueue queue) {
        int num = sc.nextInt();
        queue.enqueue(num);
    }



    public void timeTest (MyPriorityQueue arrQueue, MyPriorityQueue linkQueue) {
        System.out.println("arrQueue");
        testOneQueue(arrQueue);
        System.out.println("linkQueue");
        testOneQueue(linkQueue);



    }

    public void testOneQueue (MyPriorityQueue queue)  {
        queue.clear();
        long start = System.currentTimeMillis();


        Random random = new Random();
        for (int i = 0; i <= 10000; i++) {
            queue.enqueue(random.nextInt(1, 999));
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("Time for enqueue = " + (finish1-start));

//        System.out.println(queue.toString());

        for (int i = 0; i <= 10000; i++) {
            queue.dequeue();
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("Time for dequeue = " + (finish2-start));
    }
}