
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
    public Node head;
    public Node center;
    public Node tail;
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
/**
 * create get point
 * @param email
 * @return 
 */
      public int getPoint(String email){
          Node m = searchEmail(email);
          if(m != tail){
              return (int) m.getPoint();
          }
          return 0;
      }
/**
 * create get top
 * @return 
 */
      public int getTop(){
          return (int) head.point;
      }
/**
 * create delete top
 */
      public void deleteTop(){
          head.l.r = head.r;
          head.r.l = head.l;
          head = head.r;
      }
/**
 * create delete
 */    
      public void delete(String email){
          Node m = searchEmail(email);
          if(m == tail){
              System.out.println("Gamer not exsit!!!");
          }
          else{
              m.r.l = m.l;
              m.l.r = m.r;
              m = null;
              System.out.println("Gamer has delete");
          }
      }
/**
 * create update
 * @param email
 * @param point 
 */      
      public void update(String email, long point){
          Node m = head;
          while((!m.email.contentEquals(email) && m.point == point) && m !=tail){
              m = m.r;
          }
          if(m == tail){
              System.out.println("Gamer not exsit to update!");
          }
          insert(email, point);
          System.out.println("email" + email + "point" + point + "has update!!!");
      }
      
    /**
     *create search
     * @param email
     * @return
     */
    public Node searchEmail(String email){
          Node m = head;
          while((!m.email.contentEquals(email)) && m != tail){
              m = m.r;
          }
          return m;
      }
}