
public class LinkedQueue<T> extends LinkedList<T> {

	public LinkedQueue() {
		super();
	}
	
	public LinkedQueue(T data) {
		super(data);
	}
	
	public void enque(T data) {
		this.addLast(data);
	}
	
	public T poll() throws EmptyListException {
		return this.remove();
	}
	
}
