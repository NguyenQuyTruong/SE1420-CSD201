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
		if(currentElement==-1)
		{
			throw new Exception("Empty stack");
		}
		array[currentElement]=null;
                return array[currentElement--];
        }
     public boolean isEmpty()
	{
		return array.length==0;
        }
     public void printAll() throws Exception
	{
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");               
            }
	}
     public String topEl() 
	{
            if (currentElement != -1) {
			return null;	
		}
		return array[currentElement];
	} 
        public void print(){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");
            }
        }
      public int Size()
	{
		return array.length;
	}
	
}


