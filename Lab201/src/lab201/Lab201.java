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

/**
 *
 * @author nds72
 */
public class Lab201 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        FileReader fr = new FileReader("C:\\Users\\nds72\\Desktop\\user.csv");
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");

            doublyLinkedList.insert(arr[0], Integer.parseInt(arr[1]));
        }
    }
}
