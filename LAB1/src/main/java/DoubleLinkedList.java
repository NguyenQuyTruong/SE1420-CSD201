
public class DoubleLinkedList {
        //Create Node
    public class Node{
        private Player player;
        private Node right;
        private Node left;
        //Contructor + Setter + Getter
        public Node(Player player, Node right, Node Left){
            this.player = player;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Player getPlayer() {
            return player;
        }

        public Node getRight() {
            return right;
        }
        
    }
}
