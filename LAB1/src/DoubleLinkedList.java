
import javafx.scene.Node;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class DoubleLinkedList{
/**
 * create class Node in DoubleLinkedList
 */
    public class Node{
    public String email;
    public long point;
    Node l, r;

/**
 * Node constructor
 * @param email
 * @param point 
 */
        public Node(String email, long point) {
            this.email = email;
            this.point = point;
            l = r = null;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getPoint() {
            return point;
        }

        public void setPoint(long point) {
            this.point = point;
        }
}
/**
 * create head, center and tail
 */
    private Node head;
    private Node center;
    private Node tail;
/**
 * 
 */
      public DoubleLinkedList(){
        center = new Node(null, 0);
        tail = new Node(null, 0);
    }
      
      public void print(){
          for(Node p = center.r; p != tail; p = p.r){
              System.out.println("email" + p.email + "point" + p.point);
          }
      }
      
/**
 * create insert
 */
      
      public void insert(String email, long point){
          Node n = new Node(email, point);
          if(head == null){
              head = n;
              head.l = center;
              center.r= head;
              head.r = tail;
              tail.l = head;
          }
          if(n.point > head.point){
              center.r = n;
              n.l = center;
              n.r = head;
              head.l = n;
              tail.l = head;
          }
          if(n.point < tail.l.point){
              Node m = tail.l;
              n.r = tail;
              tail.l = n;
              m.r = n;
              n.l = m;
          }
          else{
              Node m = head;
              while(m.point > n.point){
                  m = m.r;
              }
              Node centerM = m.l;
              m.l = n;
              n.r = m;
              centerM.r = n;
              n.l = centerM;
          }
      }
      
      
}