package org.example.data;



public class LinkedPriorityQueue implements MyPriorityQueue{

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public LinkedPriorityQueue() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return head.getData();
    }

    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(int newData){
        Node newNode = new Node(newData);

        if (size == 0){
            head = newNode;
            tail = newNode;
        }else {
            Node current = head;

            while (current.getData() <= newData){
                current = current.getNext();
                if (current==null) break;
            }

            if (current == null){
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            } else {
                newNode.setPrev(current.getPrev());
                newNode.setNext(current);
                if (current.getPrev() == null) head = newNode;
                else current.getPrev().setNext(newNode);
                current.setPrev(newNode);
            }
        }

        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            return 0;
        }

        Node temp = head;
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return temp.getData();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node current = head;

        while (current != null) {
            sb.append(current.getData());
            sb.append(" ");
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

}
