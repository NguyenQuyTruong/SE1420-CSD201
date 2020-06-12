
import javax.xml.soap.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class User {
    /**
     * create class Node 
     */
    public class Node{
        public String email;
        public long point;
        public Node l, r;
    /**
     * contructor class Node
     * 
     * @param email
     * @param point
     * 
     */
        public Node(String email, long point, Node l, Node r) {
            this.email = email;
            this.point = point;
            this.l = l;
            this.r = r;
        }
        
        
    }
    
}
