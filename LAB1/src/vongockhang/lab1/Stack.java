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
	String[] storage;
	
	/**
	 * Stack constructor
	 * @param capacity init the storage limit or the length of stack
	 */
	public Stack(int capacity) {
		storage = new String[capacity]; //allocate array for storage
		top = -1; //set top as -1 which mean stack is empty
	}
	
	/**
	 * add an HTML tag to stack
	 * @param tag This tag will be added to stack 
	 * @throws StackException throw exception if reached storage limit
	 * */
	@Override
	public void Push(String tag) throws StackException {
		if (top == storage.length) {
			throw new StackException("Reached storage limit");
		}
		
		top++; //increase top
		storage[top] = tag; //set top to tag value
		
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
	
	
	/**
	 * custom exception for "my" stack
	 */
	public class StackException extends Exception{
		
		/**
		 * add this serial version to silent eclipse warning
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 
		 * @param message Message to display on CLI if throw this exception
		 */
		public StackException(String message) {
			super(message);
		}
	}

}
