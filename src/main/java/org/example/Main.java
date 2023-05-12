package org.example;



import org.example.data.HeapPriorityQueue;
import org.example.data.LinkedPriorityQueue;

import org.example.ui.QueueUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        QueueUI ui = new QueueUI();
        LinkedPriorityQueue linkQueue = new LinkedPriorityQueue();
        HeapPriorityQueue arrQueue = new HeapPriorityQueue();

        Scanner scanner = new Scanner(System.in);

        loop:
        while (true){
            menu();
            int m = scanner.nextInt();
            switch (m) {
                case 1 -> {
                    ui.runQueueUI(scanner, arrQueue);
                }
                case 2 -> {
                    ui.runQueueUI(scanner, linkQueue);
                }
                case 3 -> ui.timeTest(arrQueue, linkQueue);
                case 4 -> {break loop;}
            }
        }

    }


    private void menu(){
        System.out.println("[1] ArrayPriorityQueue");
        System.out.println("[2] LinkedPriorityQueue");
        System.out.println("[3] Time test");
        System.out.println("[4] Exit");
    }

}