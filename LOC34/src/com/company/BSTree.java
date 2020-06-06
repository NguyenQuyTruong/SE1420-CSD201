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
}
