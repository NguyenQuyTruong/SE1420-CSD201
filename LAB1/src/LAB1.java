
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
                    check =false;
                    fileSv = args[i+1];
                    break;
                case  "-a":
                    ls.insert(args[i+2], i);
                    break;
                case "-d":
                    ls.delete(args[i+1]);
                    break;
                case "-dt":
                    ls.deleteTop();
                                                       
            }
        }
        if(check == true){
            cs.writeData(fileSv, ls);
        }
        ls.print();
    }
}
