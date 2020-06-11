/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DoubleLinkedList {

    private class Node {

        private int point;
        private String email;
        private Node right;
        private Node left;

        public Node(int point, String email) {
            this.point = point;
            this.email = email;
            left = right = null;
        }
    }

    public Node header;
    private Node pre_header;
    public Node tailer;

    public void DoubleLinkedList() {
        Node newNode = new Node(-1, null);//ban dau point va email chua co se la -1 va null
        pre_header = newNode;
        tailer = new Node(-1, null);
    }

    public void insert(int point, String email) {
        Node newNode = new Node(point, email);
        if (header == null) {
            header = newNode;
            header.left = pre_header;
            header.right = tailer;
            pre_header.right = header;
            tailer.left = header;
        } else {
            if (newNode.point > header.point) {
                newNode.right = header;
                header.left = newNode;
                pre_header.right = newNode;
                newNode.left = pre_header;
                header = newNode; // update lai cai header moi
            } else if (newNode.point < tailer.left.point) {
                Node tmp = tailer.left;
                newNode.right = tailer;
                tailer.left = newNode;
                tmp.right = newNode;
                newNode.left = tmp;
            } else {
                Node tmp = header;
                while (tmp.point>newNode.point) {                    
                    tmp=tmp.right;
                }
                Node preTmp =tmp.left;
                
                newNode.right=tmp;
                tmp.left=newNode;
                newNode.left=preTmp;
                preTmp.right=newNode;
            }
        }
    }

}
