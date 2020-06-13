/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se140264;

/**
 *
 * @author ACER
 */
public class DoubleLinkedList {
    class node {
        String Name;
        int point;
        node pre, next;

        public node(String Name, int point) {
            this.Name = Name;
            this.point = point;
            pre = next = null;
        }
        
   }
    
}
