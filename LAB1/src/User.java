
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
     * constructor class Node
     * 
     * @param email
     * @param point
     * 
     */
        public Node(String email, long point, Node l, Node r) {
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
}
