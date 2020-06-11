
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liemn
 */
public class LAB1 {
    public static void main(String[] args) throws FileNotFoundException {
        DoubleLinkList ls = new DoubleLinkList();
        csv cs = new csv();
        String fileSv = null;
        boolean check = true;
        for(int i = 0;i<args.length; i++){
            switch(args[i]){
                case "-r":
                    cs.readToQueue(args [i+1], ls);
                    break;
                case "-s":
                    check =true;
                    fileSv
                    
            }
        }
    }
}
