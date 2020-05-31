package com.company;

public class Main {
    public static void main(String[] args) {
        Entry A = new Entry(2, "A");
        Entry B = new Entry(-1, "B");
        Entry C = new Entry(-1, "C");
        Entry D = new Entry(1, "D");
        SortedPriorityQueue queue = new SortedPriorityQueue();
        queue.insert(A);
        queue.insert(B);
        queue.insert(C);
        queue.insert(D);

        System.out.print(queue);
        queue.removeMin();
        System.out.print(queue);
//        System.out.print(queue.removeMin());
    }
}
