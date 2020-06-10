
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
public class queue {
    singlyLinkedList sll =new singlyLinkedList();
    //Entry manageGamer to arrayList
    private ArrayList<manageGamer> list = new ArrayList<>();
    // insert to manageGamer
    public void insert(manageGamer g) {
        int point = g.getPoint();
        int size = size();
        if (size == 0) {
            list.add(size, g);
        } else {
            for (int i = 0; i < size; i++) {
                int index = size - 1;
                if (point <= list.get(index).getPoint()) {
                    list.add(index, g);
                    return;
                }
            }
        }
    }
    //contructor queue
    public manageGamer min() {
        return list.get(0);
    }

    public manageGamer removeMin() {
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public String toString() {
        return list.toString() + "\n";
    }

}
