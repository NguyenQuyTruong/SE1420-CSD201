/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liemn
 */
public class LAB1 {
    public static void main(String[] args) {
        System.out.println("Hello Git");
        DoubleLinkList ls = new DoubleLinkList();
        ls.insert("aaa", 0);
        ls.insert("zzz", 9);
        ls.insert("ccc", 4);
        ls.insert("bbb", 7);
        ls.insert("tttt", 5);
        ls.insert("mmm", 3);
        ls.print();
       /* System.out.println("-----------");
        ls.delete("zzz");
        ls.delete("mmm");
        ls.delete("ccc");
        ls.print();*/
        System.out.println("-------------------");
        ls.deleteTop();
        ls.print();
    }
}
