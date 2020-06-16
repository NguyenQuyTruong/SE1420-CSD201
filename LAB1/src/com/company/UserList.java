/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author THINKPAD
 */
public class UserList {
    private class User{
        private String email;
        private int point;
        private User next;
        private User back;
        public User(String email, int point, User next, User back){
            this.email=email;
            this.point=point;
            this.next=next;
            this.back=back;
        }
    }
    private User Head;
    private User Tail;
    private User Find;
    public String pEmail(User a){
        return a.email;
    }
    public int pPoint(User a){
        return a.point;
    }
    public UserList() {
        Head = new User(null,Integer.MIN_VALUE, null, null);
        Tail = new User(null,Integer.MIN_VALUE,null, Head);
        Head.next = Tail;
    }
    public void Insert(String email, int point){
        User us = new User(email,point, Tail, Tail.back);
        Tail.back.next = us;
        Tail.back = us;
    }
    public void Remove(String email){
        User n = getUser(email);
        if(n != Head && n != Tail) {
            User font = n.back;
            User back = n.next;
            font.next = back;
            back.back = font;
        }
    }
    public void removeTop(){
        User top = getTop();
        Remove(top.email);
    }
    public void Update(String email, int point){
        User update= getUser(email);
        update.point = point;
    }
    public User getUser(String email){
        for (User i = Head.next; i != Tail; i=i.next)
            if (i.email.equals(email)) Find = i;
        return Find;
    }
    public User getTop(){
        int highest = Integer.MIN_VALUE;
        for (User i = Head.next; i != Tail; i=i.next)
            if (i.point > highest) {
                highest = i.point;
                Find = i;
            }
        return Find;
    }
    public void printFile(String file){
        try{
            FileWriter f = new FileWriter(file);
            f.write("Email, point\n");
            for (User i = Head.next; i != Tail; i=i.next) f.write(i.email+", "+i.point+"\n");
            f.close();
        }catch(Exception e){}
    }
    public void Read(String loadfile) {
        try{
            FileReader f = new FileReader(loadfile);
            BufferedReader b = new BufferedReader(f);
            String line = b.readLine();
            while ((line=b.readLine())!= null){
                Scanner sc = new Scanner(line).useDelimiter("\\s*, \\s*");
                String email = sc.next();
                int point = sc.nextInt();
                Insert(email, point);
            }
            f.close();b.close();
        }catch(Exception e){}
    }
}
