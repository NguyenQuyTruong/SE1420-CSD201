package Ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KHAM
 */
public class MyQueue {

    /**
     * Create Node method
     */
    private class Node {

        private Entry user;
        private Node next;

        public Node(Entry userInfo) {
            this.user = userInfo;
        }

        public Node() {
        }

        public Entry getUser() {
            return user;
        }

        public void setUser(Entry user) {
            this.user = user;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     *
     * @param e
     */
    public void enqueue(Entry e) {
        Node newNode = new Node(e);
        Node current = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (tail.user.getPoint() >= newNode.user.getPoint()) {
                tail.next = newNode;
                tail = newNode;
                size++;
                return;
            }
            if (head.user.getPoint() < newNode.user.getPoint()) {
                newNode.next = head;
                head = newNode;
                size++;
                return;
            }
            if (head.user.getPoint() == newNode.user.getPoint()) {
                newNode.next = head;
                head = newNode;
                int tmpPoint;
                String tmpEmail;
                tmpPoint = newNode.user.getPoint();
                newNode.user.setPoint(head.user.getPoint());
                head.user.setPoint(tmpPoint);
                tmpEmail = newNode.user.getEmail();
                newNode.user.setEmail(head.user.getEmail());
                head.user.setEmail(tmpEmail);
                size++;
                return;
            }
            for (current = head; current.next.next != null; current = current.next) {
                if (current.next.user.getPoint() < newNode.user.getPoint()) {
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }
                if (current.next.user.getPoint() == newNode.user.getPoint()) {
                    newNode.next = current.next.next;
                    current.next.next = newNode;
                    size++;
                    return;
                }
            }
            return;
        }
    }

    /**
     *
     * @return all point and email of Entry inserted in the queue
     */
    public String print() {
        Node current = head;
        int size2 = size;
        String str = current.user.getEmail() + ", " + current.user.getPoint() + "\n";
        for (int i = 0; i < size2 - 1; i++) {
            str = str + current.next.user.getEmail() + ", " + current.next.user.getPoint() + "\n";
            current = current.next;
        }
        return str;
    }

    /**
     * Empty the head Node and transfer it to next Node
     */
    public void dequeue() {
        head.user = null;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    /**
     * @return Entry of the user have highest point in the queue
     */
    public Entry front() {
        return head.user;
    }
    
    /**
     * 
     * @return head is empty or not
     */
    
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * 
     * @return size of queue
     */
    public int size() {
        return size;
    }
    
    /**
     * The user insert an Email to find Entry of this email
     * @param email
     * @return Entry of this email user or null if it is not exist in queue
     */
    public Entry search(String email) {
        Node current = head;
        while (current != null) {
            if (current.user.getEmail().equals(email)) {
                return current.user;
            }
            current = current.next;
        }
        return null;
    }
    /**
     * Delete the Entry of the user have the email which is insert in parameter
     * @param email 
     */
    public void delete(String email) {
        if (head.user.getEmail().equals(email)) {
            head = head.next;
            System.out.println("Deleted ! ! !");
            delete(email);
            size--;

        }
        Node current = head;

        while (current != tail) {
            if (current.next.user.getEmail().equals(email)) {
                current.next = current.next.next;
                size--;
            }
            current = current.next;
        }
    }
    /**
     * 
     * @param email
     * @param New_point
     * @return The entry of the user have this email and the point is updated
     * It will return null if this email does not exist in the queue
     */
    public Entry update(String email, int New_point) {
        if(search(email) != null){
            delete(email);
            Entry e = new Entry(New_point, email);
            enqueue(e);
            return e;
        }
        return null;
    }
}
