package org.example.ui;

import org.example.data.ArrayPriorityQueue;
import org.example.data.LinkedPriorityQueue;

import java.util.Random;
import java.util.Scanner;

public class UI {

    private void menu(){
        System.out.println("[1] Add");
        System.out.println("[2] Remove");
        System.out.println("[3] Print queue");
        System.out.println("[4] Clear queue");
        System.out.println("[5] Go Back");
    }

    public void ArrQueueUI(Scanner sc, ArrayPriorityQueue ArrQueue) {

        loop:
        while (true){
            menu();
            int m = sc.nextInt();
            switch (m) {
                case 1 -> addNum(sc, ArrQueue);
                case 2 -> System.out.println(ArrQueue.remove());
                case 3 -> System.out.println(ArrQueue.toString());
                case 4 -> {break loop;}
            }
        }
    }

    private void addNum(Scanner sc, ArrayPriorityQueue ArrQueue) {
        int num = sc.nextInt();
        ArrQueue.add(num);
    }



    public void LinkQueueUI(Scanner sc, LinkedPriorityQueue LinkQueue) {



        loop:
        while (true) {
            menu();
            int m = sc.nextInt();
            switch (m) {
                case 1 -> addNumToLinkedList(sc, LinkQueue);
                case 2 -> System.out.println(LinkQueue.remove());
                case 3 -> System.out.println(LinkQueue);
                case 4 -> {break loop;}
            }
        }
    }

    public void addNumToLinkedList(Scanner sc, LinkedPriorityQueue LinkQueue){
        int num = sc.nextInt();
        LinkQueue.add(num);
    }


    public void timeTest (ArrayPriorityQueue ArrQueue, LinkedPriorityQueue LinkQueue) {
        LinkQueue.clear();
        ArrQueue.clear();


        Random random = new Random();
        for (int i = 0; i <= 1000; i++) {
            ArrQueue.add(random.nextInt(1, 999));
        }


        for (int i = 0; i <= 1000; i++) {
            LinkQueue.add(random.nextInt(1, 999));
        }

    }
}