package com.company;

public class Main {
    public static void main(String[] args) {
        // [9 5 7 9 10 12]
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(12);
//        list.addFirst(10);
//        list.addFirst(9);
//        list.addFirst(7);
//        list.addFirst(5);
//        list.addFirst(9);
//        list.addLast(9);
//        list.addLast(5);

        System.out.print(list.removeFirst() + "\r\n");
        System.out.print(list.removeFirst() + "\r\n");
        System.out.print(list.removeLast() + "\r\n");

    }
}
