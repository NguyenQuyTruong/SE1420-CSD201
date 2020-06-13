
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        DoublyLinkedList dk = new DoublyLinkedList();
        CSV cs = new CSV();
        String save_file = null;

        boolean check = false;// kiem tra da luu file chua ban dau chua luu file

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r": //read file
                    cs.readDataToQueue(args[i + 1], dk);
                    break;

                case "-s":
                    check = true;// neu la true thi se luu file lai
                    save_file = args[i + 1];// save file dang string
                    break;
                case "-a":
                    dk.insert(Integer.parseInt(args[i + 2]), args[i + 1]);
                    break;

            }
        }
        if (check==false) {//neu van chua luu
            cs.writeData(save_file, dk);
        }
        
        dk.print();
    }
}
