/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class singlyLinkedList<G> {
    // create Node
    private class Node {
        
        private G value;
        private Node next;

        public Node(G value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
    // head and and tail of node
    private Node head = null;
    private Node tail = null;
    // top, size
    public int size() {
        int result = 0;
        for (Node s = head; s != null; s = s.next) {
            result++;
        }
        return result;
    }

    public G getTop() {
        return head.value;
    }
    // check empty
    public boolean isEmpty() {
        return head == null;
    }
    // add element
    public void addFirst(G g) {
        head = new Node(g, head);
        tail = head.next == null ? head : tail;
    }

    public void addLast(G g) {
        Node newNode = new Node(g, null);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }
        //remove
    public G removeFirst(){
        G result = null;
        if(head!=null){
            result = head.value;
            head=head.next;
            tail = head ==null ? null :tail;
        }
        return result;
    }
    // out put on screen
    public void print(){
        for(Node n = head;n!=null;n=n.next)
            System.out.println(n.value+" ");
        System.out.println("\r");
    }
    public String toString(){
        String result = "";
        for(Node n = head;n!=null;n=n.next)
            result+=n.value.toString()+" ";
        result+="\n";
        return result;
    }
    
}
