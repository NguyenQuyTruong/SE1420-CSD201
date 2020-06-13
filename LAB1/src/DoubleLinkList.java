
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

    public class Node {

        String email;
        int point;
        Node left, right;

        Node(String email, int point) {
            this.email = email;
            this.point = point;
            left = right = null;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public Node head;
    private Node pre_head;
    public Node tail;

    public DoubleLinkList() {
        Node newNode = new Node(null, -1);
        pre_head = newNode;
        tail = new Node(null, -1);
    }
// Insert email and point of player

    public void insert(String email, int point) {
        Node newNode = new Node(email, point);
        if (head == null) {
            head = newNode;
            head.left = pre_head;
            head.right = tail;
            pre_head.right = head;
            tail.left = head;
        } else {
            if (newNode.point < head.left.point) { // point nho hon head
                Node tmp = tail.left;

                newNode.right = tail;
                tail.left = newNode;
                tmp.right = newNode;
                newNode.left = tmp;
                //   tail = newNode;
            } else if (newNode.point > head.point) {//point lon hon haed

                newNode.right = head;
                head.left = newNode;
                pre_head.right = newNode;
                newNode.left = pre_head;
                head = newNode;
            } else { // middle case
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
// delete player from email

    public void delete(String email) {
        Node tmp = searchEmail(email);
        boolean check = true;
        if (tmp != tail) {

            tmp.left.right = tmp.right;
            tmp.right.left = tmp.left;
            tmp=null;
            System.out.println("Delete success");
            check = false;
        }
        if (check == true) {
            System.out.println("Fail");
        }
    }
// get info top1 

    public int geTop() {
        return head.point;
    }
// delete info top 1

    public void deleteTop() {
        head.left.right = head.right;
        head.right.left = head.left;
        pre_head.right = head.right;
        head.right.left = pre_head;
        // cap nhat lai head
        head = head.right;
    }

    // update email and point
    public void update(String email, int point) {
        Node n = searchEmail(email);
        if (n == tail) {
            System.err.println("Don't have that player!");
        }
        insert(email, point);
        System.out.println("Email: " + email + "Point: " + point);;

    }

    public int getPoint(String email) {
        Node n = searchEmail(email);
        if(n!=tail){
          return n.getPoint();
        }
        return -1;
    }

    public Node searchEmail(String emali) {
        Node n = head;
        while (!(n.email.contentEquals(emali)) && n != tail) {
            n = n.right;
        }
        return n;
    }
}
