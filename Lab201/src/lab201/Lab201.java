/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab201;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;

/**
 *
 * @author nds72
 */
public class Lab201 {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert("Cuong", 100);
        dll.insert("Sang", 9);
        dll.insert("Minh", 4);
        dll.insert("Anh", 1);
        dll.insert("Bao", 5);
        dll.print();
        System.out.println("____");
        
        dll.delete("Bao");
        System.out.println("____");
        dll.print();
    }
}
