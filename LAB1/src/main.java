/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class main {

    public static void main(String[] args) {
        singlyLinkedList list = new singlyLinkedList();
        list.insert("jack", 200);
        list.insert("jacky", 300);
        list.insert("kya", 300);
        System.out.println("Top 10 Scores: ");
        list.printList();
    }
}
