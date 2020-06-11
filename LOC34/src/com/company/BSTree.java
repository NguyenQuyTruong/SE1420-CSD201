package com.company;

public class BSTree {
    private class Node {
        private int info;
        private Node left, right;
        public Node(int value) {
            left = right = null;
            info = value;
        }
        public String toString() {
            String result = "";
            result += info;
            return result;
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
    private Node parent(Node n, Node p) {
        if(p.left == n || p.right == n) return p;
        else if(n.info > p.info) return parent(n,p.right);
        else if(n.info < p.info) return parent(n, p.left);
        else return null;
    }
    private Node search(int value, Node tree) {
        if(tree == null) return null;
        if(tree.info == value) return tree;
        else if(value > tree.info) return search(value, tree.right);
        else return search(value, tree.left);
    }
    private Node right(Node tree) {
        if(tree.right == null) return tree;
        else return right(tree.right);
    }
    public void delete(int value) {
        Node n = search(value, root);
        Node p = parent(n, root);
        if(n.left == n.right && n.right == null) {
            if(p==null) root = null;
            else if(n.info < p.info) p.left = null;
            else p.right = null;
        } else if (n.left == null || n.right == null) {
            if(n.left != null) {
                if(n == p.left) p.left = n.left;
                else p.right = n.left;
            } else {
                if(n == p.left) p.left = n.right;
                else p.right = n.right;
            }
        } else {
            Node r = right(n.left);
            if(n == p.right) {
                p.right = n.left;
                r.right = n.right;
            } else {
                p.left = n.left;
                r.right = n.right;
            }
        }
    }
}
