/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khả Thi
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
           static PriorityQueue queue;
           String filename;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        boolean saveB = false;
        String Path = null;
        for (int i = 0; i < args.length; i++) {
            switch(args[i]){
                case "r":
            {
                try {
                    queue = new PriorityQueue();
                    Csv.ReadCsv(Path, queue);
                } catch (IOException ex) {
                    Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
                case "a":
                    long apoint = Long.parseLong(args[i+1].trim());
                    queue.InSert(args[i], apoint);
                    break;
                case"u":
                    long upoint = Long.parseLong(args[i+1].trim());
                    queue.Update(args[i], upoint);
                    break;
                case"d":
                    queue.Delete(args[i]);
                    break;
                case"dt":
                    queue.DeleteT();
                    break;
                case"g":
                    queue.Find(args[i]);
                    break;
                case"t":
                    queue.Gettop();
                case"s":
                    saveB = true;
                    Path = args[i];
                    break;
                default:
                    break;
            }
        }
        if(saveB){
            Csv.WriteToFile(queue, Path);
        }
        
        
    }
    
}
