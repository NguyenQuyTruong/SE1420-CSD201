/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class main {
    public static void main(String[] args) {
        System.out.println("....");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-r")) {
                System.out.println(args[i + 1]);
                i++;
            } else if(args[i].equals("-s")) {
                System.out.println(args[i + 1]);
                i++;
            }
        }
    }
}
