/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nds72
 */
public class Lab201 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Lab201 lab = new Lab201();

        String savefile = null;
        boolean save = false;
        try {
            if (args[0].contentEquals("1")) { 
                System.out.println("Bai 1"); 
                for (int i = 0; i < args.length; i++) {
                    switch (args[i]) {
                        case "-r":
                            lab.readDataQueue(args[i + 1], doublyLinkedList);
                            break;

                        case "-a":
                            int point = Integer.parseInt(args[i + 2]);
                            doublyLinkedList.insert(args[i + 1], point);
                            break;
                        case "-u":
                            doublyLinkedList.update(args[i + 1], Integer.parseInt(args[i + 2]));
                            break;
                        case "-dt":
                            doublyLinkedList.deleteTop();
                            break;
                        case "-d":
                            doublyLinkedList.delete(args[i + 1]);
                            break;
                        case "-g":
                            doublyLinkedList.getPoint(args[i + 1]);
                            break;
                        case "-t":
                            doublyLinkedList.getTop();
                            break;
                        case "-s":
                            save = true;
                            savefile = args[i + 1];
                            break;
                        default:
                            break;

                    }

                }
                doublyLinkedList.print();
                if (save) {
                    writeDataToCsv(savefile, doublyLinkedList);

                }
            }else if (args[0].contentEquals("2")){ 
                System.out.println("Bai 2");
            }

        } catch (Exception e) {
        }

    }

    public void readDataQueue(String path, DoublyLinkedList doublyLinkedList) throws FileNotFoundException, IOException {

        int countLine = 0;
        FileReader fr = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            try {
                String[] arr = line.split(",");

                doublyLinkedList.insert(arr[0], Integer.parseInt(arr[1].trim()));
            } catch (Exception e) {
            }
        }
    }

    public static void writeDataToCsv(String path, DoublyLinkedList doublyLinkedList) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.append("Email, Point\n");
            DoublyLinkedList.Node tmp = doublyLinkedList.head;
            while (tmp != doublyLinkedList.trailer) {
                fileWriter.append(tmp.email + "," + tmp.point+"\n");
                tmp = tmp.right;
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
        }
    }
}
