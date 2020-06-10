
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
/**    
   * Check if List is empty or not
   *
   * @return Player
   */ 
    public boolean isEmpty(){
        return nodeSize == 0;
    }
/**    
   *Return Size of the List
   * 
   * @return number of size
   */ 
    public int sizeOfList(){
        return nodeSize;
    }
/**     
   * Return the data of the Player on top of the List
   * 
   *  @return Player
   */ 
    public Player getFirst(){
        //Check if the List is Empty or not...
        if(isEmpty()){
            return null;
        }else{
            //Return the Player's data
            return head.getNext().getPlayer();
        }
    }
/**    
   * Return the data of the Player on the bottom of the List
   * 
   *  @return Player
   */ 
    public Player getLast(){
        //Check if the List is Empty or not...
        if(isEmpty()){
            return null;
        }else{
            //Return the Player's data
            return trail.getPrev().getPlayer();
        }
    }
/**    
   * Remove a node from List
   * 
   * @param playerNode
   * @return Data of the removed node
   */ 
    private Player remove(Node playerNode){
        Node nextNode = playerNode.getNext();
        Node prevNode = playerNode.getPrev();
        prevNode.setPrev(prevNode);
        nextNode.setNext(nextNode);
        nodeSize--;
        return playerNode.getPlayer();
    }
/**    
   * Remove the Last Player of the List
   * 
   *  @Data of the removed Player
   */ 
    public Player removeLast(){
        if(isEmpty()){
            return null;
        }else{
            return remove(trail.getPrev());
        }
    }
/**    
   * Remove the First Player of the List
   * 
   *  @Data of the removed Player
   */ 
    public Player removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            return remove(head.getNext());
        }
    }

    public void deletePlayerNode(String email){
        //Check if the List is Empty or not...
        if(isEmpty()){
            System.out.println("The List is Empty... Try input some data first.");
        } else{
            Node playerNode;
        }
    }
    /**
     * Find the node for priority queue what is higher
     * 
     * @param inputpoint
     * @return Node
     */
    public Node searchNode(int inputpoint){
        //Get Node after head
        Node nextNode = head.getNext();
        
        do{
            if (nextNode.getPlayer().getPoint() > inputpoint)//find the first player that have higher point
            {
                return nextNode;
            } else {
                nextNode = nextNode.getNext(); //Move to next Node
            }
        } while (nextNode != trail);
        return null;   //this is the highest point on the List
    }
    /**
     * Find node that the Player have the same inputted email
     * 
     * @param email
     * @return Player (null if not found)
     */
    public Node searchPlayerbyEmail (String email){
        //Check if the List is Empty or not
        if(isEmpty()){
            System.out.println("The List is Empty... Try input some data first.");
        }else{
            Node nextNode = head.getNext();
            
            do{
                //Compare the email inputed
                if(nextNode.getPlayer().equals(email)){
                    return nextNode;
                }else{nextNode.getNext();}//If not, then go to the next node
            }while(nextNode != trail);
        }
        return null; //when the node is not found.
    }
}
