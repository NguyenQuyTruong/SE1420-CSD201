/**
 * 
 */
package problem2;

import problem2.Stack.StackException;

/**
 * @author skyho
 *
 */
public interface IStack {
	public void Push(String tag) throws StackException; //push HTML tag to top of the stack
	public String Pop() throws StackException; //get the top value and remove it from stack
	public String GetTop(); //get the top value [without remove it]
	public boolean IsEmpty(); //check stack is empty or not
}
