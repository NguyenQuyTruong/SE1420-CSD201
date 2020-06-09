
import java.io.PrintWriter;

public class DoubleLinkedList {
        //Create Node
    public class Node{
        private Player player;
        private Node next;
        private Node prev;
        //Contructor + Setter + Getter
        public Node(Player player, Node right, Node Left){
            this.player = player;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public Player getPlayer() {
            return player;
        }

        public Node getPrev() {
            return prev;
        }
       
    }
    private Node head;
    private Node trail;
    private int nodeSize = 0;               
    
    //Default Contructor
            
    public DoubleLinkedList(){
        head = new Node(null,null,null);
        trail = new Node(null,null,head);
        head.setNext(head);
    }
    
}
