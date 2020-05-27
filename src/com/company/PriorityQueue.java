package com.company;

import com.company.Entry;

public interface PriorityQueue {
    public Entry removeMin();
    public Entry min();
    public boolean isEmpty();
    public int size();
    public String toString();
}
