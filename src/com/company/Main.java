package com.company;

public class Main {
    public static void main(String[] args) {
        Entry A = new Entry(0, "A");
        Entry B = new Entry(1, "B");
        Entry C = new Entry(2, "B");
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(A);
        queue.enqueue(B);
        queue.enqueue(C);
        Entry e = queue.dequeue();
        e.set_rank(5);

        System.out.print(A);
    }
}
