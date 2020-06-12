
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        DoubleLinkedList d = new DoubleLinkedList();
        Main l = new Main();
        String savefile = null;
        boolean save = false;
        d.print();
        for(int a = 0; a < args.length; a++){
            switch(args[a]){
                case "-r":
                    l.readDataQueue(args[a + 1], d);
                    break;
                case "-a":
                    int point = Integer.parseInt(args[a + 2]);
                    d.insert(args[a + 1], point);
                    break;
                case "-u":
                    d.update(args[a + 1], Integer.parseInt(args[a + 2]));
                    break;
                case "-dt":
                    d.deleteTop();
                    break;
                case "-d":
                    d.delete(args[a + 1]);
                    break;
                case "-g":
                    d.getPoint(args[a + 1]);
                    break;
                case "-t":
                    d.getTop();
                    break;
                case "-s":
                    save = true;
                    saveFile = args[a + 1];
                    break;
                default:
                    break;
            }
        }
        
        d.print();
        if(save){
            writeDataToCsv(saveFile, d);
        }
    }
}
