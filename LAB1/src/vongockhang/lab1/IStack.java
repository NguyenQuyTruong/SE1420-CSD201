/**
 * 
 */
package vongockhang.lab1;

/**
 * @author skyho
 *
 */
public interface IStack {
	public void Push(String tag); //push HTML tag to top of the stack
	public String Pop(); //get the top value and remove it from stack
	public String GetTop(); //get the top value [without remove it]
	public boolean IsEmpty(); //check stack is empty or not
}
