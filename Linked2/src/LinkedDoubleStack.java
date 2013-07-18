/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleStack<T> extends LinkedDoubleList<T> implements StackInterface<T> {

	public LinkedDoubleStack() {
		super();
	}
	
	public LinkedDoubleStack(T data) {
		super(data);
	}

	@Override
	public void push(T data) {
		this.insertFirst(data);
	}

	@Override
	public T pop() throws EmptyListException {
		return this.removeFirst();
	}

	@Override
	public T top() throws EmptyListException {
		return this.peekFirst();
	}
	

	
}
