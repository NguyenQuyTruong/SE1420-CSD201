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
            if (tail.user.getPoint() >= newNode.user.getPoint() && head.next == null) {
                tail.next = newNode;
                tail = newNode;
                size++;
                return;
            }
            if (head.user.getPoint() <= newNode.user.getPoint()) {
                newNode.next = head;
                head = newNode;
                size++;
                return;
            }
            for (current = head; current.next != null; current = current.next) {
                if (current.next.user.getPoint() <= newNode.user.getPoint()) {
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }
            }
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }
    }

    public String print() {
        Node current = head;
        String str = current.user.getEmail() + ", " + current.user.getPoint() + "\n";
        for (int i = 0; i < size - 1; i++) {
            str = str + current.next.user.getEmail() + ", " + current.next.user.getPoint() + "\n";
            current = current.next;
        }
        return str;
    }

    public Entry dequeue() {
        Entry firstUser = head.user;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return firstUser;
    }

    public Entry front() {
        return head.user;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

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

    public Entry delete(String email) {
        Node deleted = null;
        Node current = head;
        if (head.user.getEmail().equals(email)) {
            head = head.next;
            return head.user;
        }

        while (current != tail) {
            if (current.next.user.getEmail().equals(email)) {
                deleted = current.next;
                current.next = current.next.next;
                return deleted.user;
            }
            current = current.next;
        }
        return deleted.user;
    }

    public Entry update(String email, int New_point) {
        Entry user = search(email);
        if (user != null) {
            user.setPoint(New_point);
            return user;
        }
        return null;
    }

}
