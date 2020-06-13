/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se140264;

import java.io.IOException;

/**
 *
 * @author ACER
 */
public class Lab201 {

    public static void main(String[] args) throws IOException {
        DoubleLinkedList dll = new DoubleLinkedList();
        readNsave rns = new readNsave();

        String savefile = null;
        boolean savePermission = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r":
                    rns.readDataToQueue(args[i+1], dll);
                    break;

                case "-s":
                    savePermission = true;
                    savefile = args[i+1]; 
                    break;
                case "-a":
                    dll.add(args[i+1],Integer.parseInt(args[i+2]));
                    break;
                case "-d":
                    dll.remove(args [i+1]);
                    break;
                case "-u":
                    dll.update(args [i+1], Integer.parseInt(args [i+2]));
                    break;
                case "-dt":
                    dll.removeTop();
                    break;
                case "-g":
                    if(dll.getPoint(args[i+1])==0) System.out.println("Name not found!");
                    else{
                        System.out.println(dll.getPoint(args[i+1]));
                    }
                    break;
                case "-t":
                    dll.getTop();
                    break;
                    
                    
            }
        }
        
        
        
        
        
        if(savePermission){ 
            rns.writeData(savefile, dll);
        }

        
        dll.print();

    }
    
}
