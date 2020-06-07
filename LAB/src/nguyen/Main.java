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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SortLinkedList list = new SortLinkedList();
        list.add("tran van a", 5);
        list.add("thit ga", 10);
        list.add("thit heo", 99);
        list.add("cute", 1111);
        list.add("silver", 55);
        list.add("bach ho", 26);
        list.add("thanh long", 2222);
        list.printsortList();
        System.out.println("==Search MaxPonit Player==");
        list.SearchMaxpointPlayer();
        list.printsortList();
        System.out.println("==Remove MaxPonit Player==");
        list.RemoveMaxPointPlayer();
        list.printsortList();
        System.out.println("==Search Bach Ho==");
        System.out.println(list.SearchPlayerEmail("bach ho"));
        System.out.println("==Updata tran van a >>8888 point==");
        list.UpdatePlayer("tran van a", 8888);
        list.printsortList();
    }
    
}
