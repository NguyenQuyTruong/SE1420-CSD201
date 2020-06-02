/**
 * 
 */
package vongockhang.lab1;

/**
 * @author skyho
 *
 */
public class Stack implements IStack{
	int top;
	int[] storage;
	
	/**
	 * Stack constructor
	 * @param capacity init the storage limit or the length of stack
	 */
	public Stack(int capacity) {
		storage = new int[capacity]; //allocate array for storage
		top = -1; //set top as -1 which mean stack is empty
	}
	
	/**
	 * add an HTML tag to stack
	 * @param tag This tag will be added to stack 
	 * */
	@Override
	public void Push(String tag) {
		
		
	}

	@Override
	public String Pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean IsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
