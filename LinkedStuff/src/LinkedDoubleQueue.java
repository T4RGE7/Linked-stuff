/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedDoubleQueue<T> {

	private LinkedDoubleNode<T> head, current;
	private int size;
	
	public LinkedDoubleQueue() {
		this.head = null;
		this.current = null;
		this.tail = null;
		this.size = 0;
	}
	
	public LinkedDoubleQueue(T data) {
		this.head = new LinkedDoubleNode<T>(data);
		this.current = null;
		this.tail = null;
		this.size = 1;
	}
	
	
}
