package com.company;
import java.util.LinkedList;
import com.company.Entry;

public class UnsortedPriorityQueue implements PriorityQueue {
    //private SinglyLinkedList<Entry> _list = new SinglyLinkedList<Entry>();
    private LinkedList<Entry> _list = new LinkedList<Entry>();
    public void insert(Entry e) {
        _list.addLast(e);
    }
    public Entry removeMin() {
        Entry min_entry = min();
        _list.remove(min_entry);
        return min_entry;
    }

    public Entry min() {
        int min_rank = _list.get(0).get_rank();
        int min_index = 0;
        for(int i = 1; i < size(); i++) {
            int rank = _list.get(i).get_rank();
            if (min_rank > rank) {
                min_rank = rank;
                min_index = i;
            }
        }
        return _list.get(min_index);
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
    public int size() {
        return  _list.size();
    }

    public String toString() {
        return _list.toString() + "\n";
    }
}
