/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenLab2;

/**
 *
 * @author ADMIN
 */
public class Stack {
     int currentElement;
     String array[];
     public Stack(int sopt) {
        array=new String[sopt];
        currentElement=-1;//mang chua co phan tu
     }
     public void push(String element) throws Exception
	{
		if(currentElement!=array.length){
                    throw new  Exception("Full Stack");
                }
                currentElement++;
               
                    
	}	
}
