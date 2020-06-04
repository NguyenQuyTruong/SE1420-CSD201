
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KHAM
 */
public class MaxInHeap implements Manager {
    // Using heaps
    
    private int capacity = 7;
    private int size = 0;
    int items[] = new int[capacity];
    
    // Using given index to find its left, right and parent index
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    
    
    //Get value of left, right or parent of given index
    public int getLeftChild(int parentIndex){
        return items[getLeftChildIndex(parentIndex)];
    }
    public int getRightChild(int parentIndex){
        return items[getRightChildIndex(parentIndex)];
    }
    public int getParent(int childIndex){
        return items[getParentIndex(childIndex)];
    }
    
    //Check existance of left, right or parent of given index
    
    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    public boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    public boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
    
    public void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    //When size are over capacity of items array, It will double its capacity
    
    public void extendCapacity(){
        if(capacity == size){
            items = Arrays.copyOf(items, capacity*2);
            capacity = capacity*2;
        }
    }
    
    
    @Override
    public int getMaxValue() {
        if(size == 0) throw new IllegalStateException(); // Check empty array
        return items[0];
    }

    @Override
    public void deleteMaxValue() {
        if(size == 0) throw new IllegalStateException(); // Check empty array
        int maxValue = items[0];
        items[0] = items[size -1];
        size--;
        pullUp();
    }

    public void pullUp(){
        int index = 0;
        if(hasLeftChild(index)){
            int BiggerChildIndex = getLeftChildIndex(index);
            //If right child value is bigger than left child value
            if(hasRightChild(index) && getLeftChild(index) < getRightChild(index)){
                BiggerChildIndex = getRightChildIndex(index);
            }
            if(items[index] > items[BiggerChildIndex]){
                break;
            }
            if(items[index] < items[BiggerChildIndex]){
                
            }
        }
    }
    
    @Override
    public void add(int value) {
        
    }

}
