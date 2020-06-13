
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

    public static void main(String[] args) throws FileNotFoundException {
        DoublyLinkedList dk = new DoublyLinkedList();
        CSV cs = new CSV();
        String savefile = null;

        boolean willsave = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r": //read file
                    cs.readDataToQueue(args[i + 1], dk);
                    break;

                case "-s":
                    willsave = true;
                    savefile = args[i + 1];
                    break;
                case "-a":
                    dk.insert(Integer.parseInt(args[i + 2]), args[i + 1]);
                    break;

            }
        }
    }
}
