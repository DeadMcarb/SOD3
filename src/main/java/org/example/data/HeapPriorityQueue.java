package org.example.data;



public class HeapPriorityQueue implements MyPriorityQueue{
    private final int MAX_SIZE;
    private int [] heap;
    private int size;

    public HeapPriorityQueue() {
        MAX_SIZE = 100001;
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public HeapPriorityQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int leftChild(int i) {
        return 2*i + 1;
    }

    public static int rightChild(int i) {
        return 2*i + 2;
    }

    @Override
    public void clear() {
        heap = new int[MAX_SIZE];
        size = 0;
    }

    public int peek() {
        return heap[0];
    }

    public void enqueue(int data) {
        if (size >= MAX_SIZE) {
            System.out.println("The queue is full. Cannot insert");
            return;
        }


        heap[size] = data;
        size = size + 1;


        int i = size - 1;
        while (i != 0 && heap[HeapPriorityQueue.parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = HeapPriorityQueue.parent(i);
        }
    }


    public void minHeapify(int i){

        int left = HeapPriorityQueue.leftChild(i);
        int right = HeapPriorityQueue.rightChild(i);


        int smallest = i;


        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }


        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }


        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }

    }


    public int dequeue() {
        int maxItem = heap[0];


        heap[0] = heap[size - 1];
        size = size - 1;

        minHeapify(0);
        return maxItem;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(heap[i] + " ");
        }

        sb.append("]");
        return sb.toString();
    }


}