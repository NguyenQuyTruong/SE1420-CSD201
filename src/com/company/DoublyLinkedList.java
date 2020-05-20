package com.company;


public class DoublyLinkedList {
    private class Node {
        private int value;
        private Node next;
        private Node prev;
        public Node (int value, Node next_node, Node prev_node) {
            this.value = value;
            this.next = next_node;
            this.prev = prev_node;
        }
    }
    private Node header;
    private Node trailer;
    public DoublyLinkedList() {
        header = new Node(Integer.MIN_VALUE, null, null);
        trailer = new Node(Integer.MIN_VALUE,null, header);
        header.next = trailer;
    }
    private void insert(int value, Node font, Node back){
        Node new_node = new Node(value, back, font);
        font.next = new_node;
        back.prev = new_node;
    }
    public void addFirst(int value) {
        insert(value, header, header.next);
    }
    public void addLast(int value) {
        insert(value, trailer.prev, trailer);
    }
    private Node remove(Node n) {
        if(n != header && n != trailer) {
            Node font = n.prev;
            Node back = n.next;
            font.next = back;
            back.prev = font;
        }
        return n;
    }
    public int removeFirst() {
        return remove(header.next).value;
    }
    public int removeLast() {
        return remove(trailer.prev).value;
    }
    public void print() {
        for(Node n = header.next; n != trailer; n=n.next)
            System.out.print(n.value + " ");
        System.out.print("\r\n");
    }
}
