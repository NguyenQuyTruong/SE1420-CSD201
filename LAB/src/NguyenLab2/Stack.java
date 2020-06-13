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
		if(currentElement==array.length){
                    throw new  Exception("Full Stack");
                }
                currentElement++;
                array[currentElement]=element;
                    
	}	
     public String pop() throws Exception
	{
		if(currentElement!=-1)
		{
			throw new Exception("Empty stack");
		}
                return array[currentElement--];
	}	
     public boolean isEmpty()
	{
		return array.length==0;}
}

