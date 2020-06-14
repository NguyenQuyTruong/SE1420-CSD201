
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Chi  Cuong
 */
public class LAB1 {
    public static void main(String[] args) throws IOException {
        DoublyLinkedList d = new DoublyLinkedList();
        
        d.add("H", 5);
        d.add("LL", 1);
        d.add("k", 2);
        d.add("jj", 3);
        d.add("jaj", 9);
        d.update("H", 1000);
                
//        d.print();
        FileCsv fc=new FileCsv();
        fc.readDataFormFileCsv("D:\\CSD\\lab1\\SE1420-CSD201\\LAB1\\user.csv", d);
        fc.write("csvvv.csv", d);
        
    }
}
