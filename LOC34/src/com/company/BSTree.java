package com.company;

public class BSTree {
    private class Node {
        private int info;
        private Node left, right;
        public Node(int value) {
            left = right = null;
            info = value;
        }
    }
    private Node root;
    public BSTree() { root = null; };

    private void visit(Node p) {
        System.out.print(p.info + " ");
    }

    private void inOrder(Node p) {
        if(p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    public void print() {
        inOrder(root);
        System.out.println("");
    }
    public void insert(int value) {
        root = insertNode(value, root);
    }
    private Node insertNode(int value, Node p) {
        if(p == null) p = new Node(value);
        if(value > p.info) p.right = insertNode(value, p.right);
        else if (value < p.info) p.left = insertNode(value, p.left);
        return p;
    }

}
