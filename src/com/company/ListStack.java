package com.company;

public class ListStack implements Stack {
    private SinglyLinkedList list = new SinglyLinkedList();

    @Override
    public void push(int info) {
        list.addFirst(info);
    }

    @Override
    public int pop() {
        return list.removeFirst();
    }

    @Override
    public int top() {
        return list.getTop();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void print() {
        list.print();
    }
}
