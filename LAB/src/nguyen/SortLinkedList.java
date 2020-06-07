/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen;

/**
 *
 * @author ADMIN
 */
public class SortLinkedList {
    Player head;
    Player tail;
    public SortLinkedList(){
        head=tail=null;
    }
   
    public Player ceiling(int pointlling){
        Player t = tail;
        while(t!=null && t.getPoint()>pointlling) 
        {            
            t=t.getNextPlayer();
        }
        return t;
    }
}