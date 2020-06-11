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
            pre_head.left = head;
            tail.left = head;
        } else {
            if (newNode.point < head.point) {
                newNode.right = tail;
                tail.left = newNode;
                newNode.left = head;
                head.right = newNode;
                tail = newNode;
            } else if (newNode.point > head.point) {
                newNode.right = head;
                head.left = newNode;
                pre_head.right = newNode;
                newNode.left = pre_head;
            } else {
                Node tmp = head;
                while (tmp.point > newNode.point) {
                    tmp = tmp.right;
                }
                Node preTmp = tmp.left;
                newNode.right = tmp;
                tmp.left = newNode;
                newNode.left = tmp.left;
                tmp.left.right = newNode;

            }
        }

    }

    public void print() {
        for (Node n = pre_head.right; n != tail; n = n.right) {
            System.out.println("Email" + n.email + " Point" + n.point);
        }
    }
  public static void main(String[] args) {
        DoubleLinkList ls = new DoubleLinkList();
        ls.insert("aaa", 9);
    //    ls.insert("xxx", 2);
    //    ls.insert("zzz", 6);
     //   ls.insert("ppp", 5);
     //   ls.print();
    }
  
}

