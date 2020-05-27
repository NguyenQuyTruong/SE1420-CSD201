package com.company;

public class SinglyLinkedList<E> {
    private class Node {
        private E value;
        private Node next;
        public Node (E value, Node node) {
            this.value = value;
            this.next = node;
        }
    }
    private Node head = null;
    private Node tail = null;
    public SinglyLinkedList() {}

    private Node getLastNode() {
        Node result = null;
        for(Node n = head; n != null; n=n.next) result = n;
        return result;
    }

    public int size() {
        int result = 0;
        for(Node n = head; n != null; n=n.next) result++;
        return result;
    }
    public E getTop() {
        return head.value;
    }
    public void addFirst(E e) {
        head = new Node(e, head);
        tail = head.next == null ? head: tail;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(E e) {
        Node new_node = new Node(e, null);
        if(isEmpty()) {
            head = new_node;
            tail = head;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }


    public void print() {
        for(Node n = head; n != null; n=n.next)
            System.out.print(n.value + " ");
        System.out.print("\r\n");
    }

    public String toString() {
        String result = "";
        for(Node n = head; n != null; n=n.next)
            result += n.value.toString() + " ";
        result += "\n";
        return result;
    }

    public E removeFirst() {
        E result = null;
        if(head != null) {
            result = head.value;
            head = head.next;
            tail = head == null ? null : tail;
        }
        return result;
    }
}
