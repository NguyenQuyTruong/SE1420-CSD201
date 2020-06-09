
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
    //
    //Check if List is empty or not
    //
    //return @Player
    //
    public boolean isEmpty(){
        return nodeSize == 0;
    }
    //
    //Return Size of the List
    //
    //@return number of size
    //
    public int sizeOfList(){
        return nodeSize;
    }
     //
    //Return the data of the Player on top of the List
    //
    // @return Player
    //
    public Player getFirst(){
        //Check if the List is Empty or not...
        if(isEmpty()){
            return null;
        }else{
            //Return the Player's data
            return head.getNext().getPlayer();
        }
    }
    //
    //Return the data of the Player on the bottom of the List
    //
    // @return Player
    //
    public Player getLast(){
        //Check if the List is Empty or not...
        if(isEmpty()){
            return null;
        }else{
            //Return the Player's data
            return trail.getPrev().getPlayer();
        }
    }
    //
    //Remove a node from List
    //
    //@param playerNode
    //@return Data of the removed node
    //
    private Player remove(Node playerNode){
        Node nextNode = playerNode.getNext();
        Node prevNode = playerNode.getPrev();
        prevNode.setPrev(prevNode);
        nextNode.setNext(nextNode);
        nodeSize--;
        return playerNode.getPlayer();
    }
    //
    //Remove the Last Player of the List
    //
    // @Data of the removed Player
    //
    public Player removeLast(){
        
    }
    //
    //Remove the First Player of the List
    //
    // @Data of the removed Player
    //
    public Player removeFirst(){
        
    }
}
