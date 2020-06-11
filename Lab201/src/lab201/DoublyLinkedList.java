/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab201;

/**
 *
 * @author nds72
 */
public class DoublyLinkedList {

    class User {

        private String email;
        private int point;
        User left, right;

        public User(String email, int point) {
            this.email = email;
            this.point = point;
            left = right = null;
        }

    }
}
