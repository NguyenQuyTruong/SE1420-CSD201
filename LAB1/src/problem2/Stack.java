/**
 * 
 */
package problem2;

/**
 * @author skyho
 *
 */
public class Stack implements IStack{
	int top;
	String[] storage;
	
	/**
	 * Stack constructor
	 * @param capacity initiate the storage limit or the length of stack
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

	/**
	 * return top value then remove it from stack
	 * 
	 * @return String stack top value
	 * @throws StackException 
	 * 
	 */
	@Override
	public String Pop() throws StackException {
		if (top == -1) {
			throw new StackException("Stack is empty");
		}
		
		storage[top] = null; //free mem
		return storage[top--];
	}

	/**
	 * Get top value of stack, without remove it
	 * @return String stack top value
	 */
	@Override
	public String GetTop() {
		if (top == -1) {
			return null;	
		}
		return storage[top];
	}

	/**
	 * Check if stack is empty
	 */
	@Override
	public boolean IsEmpty() {
		if (top == -1) {
			return true;
		}
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
