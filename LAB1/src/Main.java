/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KHAM
 */
public class Main {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        Entry user1 = new Entry(72, "ygtoi@gmail.com");
        Entry user2 = new Entry(543, "pmywc@gmail.com");
        Entry user3 = new Entry(9032, "gkfjenp@gmail.com");
        Entry user4 = new Entry(5517, "syevvdcfts@gmail.com");
        Entry user5 = new Entry(8, "yyvnztwki@gmail.com");

        mq.enqueue(user1);
        mq.enqueue(user2);
        Entry e = mq.front();
        System.out.println(e.getPoint());
    }
}
