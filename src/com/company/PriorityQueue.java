package com.company;
import com.company.Entry;
//import com.company.SinglyLinkedList;

public class PriorityQueue {
    private SinglyLinkedList<Entry> _list = new SinglyLinkedList<Entry>();
    public void enqueue(Entry e) {
        _list.addLast(e);
    }

    public Entry dequeue() {
        return _list.removeFirst();
    }
    public Entry first() {
        return _list.getTop();
    }
    public boolean isEmpty() {
        return _list.isEmpty();
    }
    public int size() {
        return  _list.size();
    }

    @Override
    public String toString() {
        return _list.toString();
    }
}
