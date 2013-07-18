/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleStack<T> extends LinkedDoubleList<T> {

	public LinkedDoubleStack() {
		super();
	}
	
	public LinkedDoubleStack(T data) {
		super(data);
	}
	
	public void push(T data) {
		this.add(data);
	}
	
	public T pop() throws EmptyListException {
		return this.remove();
	}
	
}
