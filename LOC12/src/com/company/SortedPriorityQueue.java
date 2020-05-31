package com.company;

import java.util.ArrayList;

public class SortedPriorityQueue {
    private ArrayList<Entry> _list = new ArrayList<>();
    public void insert(Entry e) {
        int rank = e.get_rank();
        int size = size();
        if(size == 0) {
            _list.add(size, e);
        } else {
            for(int i = 0; i < size; i++) {
                int index  = size - i - 1;
                if(rank <= _list.get(index).get_rank()) {
                    _list.add(index, e);
                    return;
                }
            }
        }
    }
    public Entry removeMin() {
        return _list.remove(0);
    }

    public Entry min() {
        return _list.get(0);
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
