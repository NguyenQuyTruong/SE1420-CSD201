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
    public boolean isEmpty(){
        return head==null;
    }
   
    public Player ceiling(int pointlling){
        Player t = head;
        while(t!=null && t.getPoint()>pointlling) 
        {            
            t=t.getNextPlayer();
        }
        return t;
    }
    public Player PlayerSearchEmail(String Email){
        Player Result;
        for(Result=head; Result!=null; Result=Result.nextPlayer){
            if(Result.getEmail().equals(Email)){
                return Result;
            }
        }
        return Result;
    }
}