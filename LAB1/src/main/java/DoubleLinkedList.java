
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class DoubleLinkedList {
        //Create Node
    public class Node{
        private Player player;
        private Node next = null;
        private Node prev = null;
        //Contructor + Setter + Getter
        public Node(Player player, Node next, Node Left){
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
    Node head;
    Node trail;
    private int nodeSize = 0;               
    
    //Contructor
            
    public DoubleLinkedList(){
        head = new Node(null,null,null);
        trail = new Node(null,null,head);
        head.setNext(head);
    }
/**    
   * Check if List is Empty or not
   *
   * @return Player
   */ 
    public boolean isEmpty(){
        return nodeSize == 0;
    }
/**    
   *Return Size of the List
   * 
   * @return number of nodeSize
   */ 
    public int nodeSizeOfList(){
        return nodeSize;
    }
    /**
     * Method for adding Node on the top
     *
     * @param newNode
     */
    public void addFirst(Node newNode) {
        head.next.prev = newNode;
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
    }

    /**
     * Method for Adding New Node near Trail
     *
     * @param newNode
     */
    public void addLast(Node newNode) {
        trail.prev.next = newNode;
        newNode.prev = trail.prev;
        newNode.next = trail;
        trail.prev = newNode;
    }

    /**
     * Method for adding element between the Node
     *
     * @param data
     */
    public void addBetween(Player data) {
        Node newbie = new Node(data, trail, head);
        int point = data.getPoint();
        //Check If List is Empty
        if (isEmpty()) {
            head.next = newbie;
            newbie.prev = head;
            newbie.next = trail;
            trail.prev = newbie;
        } else {
            int pointOfHeader = head.next.getPlayer().getPoint();
            int pointOfTrailer = trail.prev.getPlayer().getPoint();
            //if input point < point of trail, add new trail
            if (point < pointOfTrailer) {
                addLast(newbie);
            } //if input point > point of head, add new head
            else if (point > pointOfHeader) {
                addFirst(newbie);
            } //normal case, go through the list and compare every node until get next position
            else {
                Node currentNode = head.next;
                while (currentNode.getPlayer().getPoint() > newbie.getPlayer().getPoint()) {
                    currentNode = currentNode.next;
                }
                currentNode.prev.next = newbie;
                newbie.next = currentNode;
                newbie.prev = currentNode.prev;
                currentNode.prev = newbie;
            }
        }
        nodeSize++;
    }

    /**
     * Removing Node Method
     *
     * @param node
     * @return info of node
     */
    private Player remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.setNext(next);
        next.setPrev(prev);
        nodeSize--;
        return node.getPlayer();
    }

    /**
     * Method for returning the First Player for the list
     *
     * @return Player
     */
    public Player first() {
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getPlayer();
    }

    /**
     * Method for Removing the first
     */
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty!!");
        } else {
            remove(head.getNext());
        }
    }

    /**
     * Method for returning the data of the inputted email
     *
     * @param email
     * @return Player
     */
    public Player searchPlayerByEmail(String email) {
        for (Node n = head.next; n != trail; n = n.next) {
            if (n.getPlayer().getEmail().contentEquals(email)) {
                return n.getPlayer();
            }
        }
        return null;
    }

    /**
     * Method for Checking the whole List for an email to delete
     *
     * @param email
     * @return Node
     */
    public Node searchPlayerToDelete(String email) {
        for (Node n = head.next; n != trail; n = n.next) {
            if (n.getPlayer().getEmail().contentEquals(email)) {
                return n;
            }
        }
        return null;
    }

    /**
     * Method for deleting the node of the Player have the input email
     *
     * @param email
     * @return Player has been remove
     */
    public Player removeNode(String email) {
        Node delNode = searchPlayerToDelete(email);
        if (delNode != null) {
            return remove(delNode);
        }
        return null;
    }
    /**
     * Method to write down to .csv file
     * 
     * @param fileName
     * @throws IOException 
     */
    public void writeToCSVfile(String fileName) throws IOException {
        FileWriter fr = null;
        try {
            fr = new FileWriter(fileName);
	    fr.append("Email, Point\n");
            for (Node n = head.next; n != trail; n = n.next) {
                String data = String.format("%s, %d\n", n.getPlayer().getEmail(), n.getPlayer().getPoint());
                fr.append(data);
            }
        } catch (IOException e) {
            System.out.println("Something wrong with writing to file!!");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("File not exist!!");
            }
        }
    }
    /**
     * Method for Printing the List out
     */
    public void printList() {
        //Begin After the Head
        Node currentNode = head.getNext();
        //Loop will scan every node
        while (currentNode != trail) {
            System.out.println(currentNode.getPlayer() + "\n");
            currentNode = currentNode.getNext();
        }
    }
}
