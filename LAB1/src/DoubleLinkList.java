
import jdk.nashorn.internal.ir.BreakNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liemn
 */
public class DoubleLinkList {

    private class Node {

        String email;
        int point;
        Node left, right;

        Node(String email, int point) {
            this.email = email;
            this.point = point;
            left = right = null;
        }
    }
    private Node head;
    private Node pre_head;
    private Node tail;

    public DoubleLinkList() {
        Node newNode = new Node(null, -1);
        pre_head = newNode;
        tail = new Node(null, -1);
    }

    public void insert(String email, int point) {
        Node newNode = new Node(email, point);
        if (head == null) {
            head = newNode;
            head.left = pre_head;
            head.right = tail;
            pre_head.right = head;
            tail.left = head;
        } else {
            if (newNode.point < head.left.point) { // be hon head
                Node tmp = tail.left;

                newNode.right = tail;
                tail.left = newNode;
                tmp.right = newNode;
                newNode.left = tmp;
                //   tail = newNode;
            } else if (newNode.point > head.point) {

                newNode.right = head;
                head.left = newNode;
                pre_head.right = newNode;
                newNode.left = pre_head;
                head = newNode;
            } else {
                Node tmp = head;
                while (tmp.point > newNode.point) {
                    tmp = tmp.right;
                }
                Node preTmp = tmp.left;
                newNode.right = tmp;
                tmp.left = newNode;
                newNode.left = preTmp;
                preTmp.right = newNode;

            }
        }

    }

    public void print() {
        for (Node n = pre_head.right; n != tail; n = n.right) {
            System.out.println("Email: " + n.email + " " + " Point: " + n.point);
        }
    }

    public void delete(String email) {
        Node tmp = head;
        while (!(tmp.email.equals(email)) && tmp != tail) {
            tmp = tmp.right;
        }
        boolean check = true;
        if (tmp != tail) {

            tmp.left.right = tmp.right;
            tmp.right.left = tmp.left;
            System.out.println("Delete success");
            check = false;
         
        }
        if (check==true) {
            System.out.println("Fail");
        }
    }

    public int geTop() {
        return head.point;
    }

    public void deleteTop() {
        head.left = head.right;
        head.right = head.left;
        pre_head.right = head.right;
        head.right = pre_head;
        // cap nhat lai head
        head = head.right;
    }

}
