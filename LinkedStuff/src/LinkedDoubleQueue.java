/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedDoubleQueue<T> {

	private LinkedDoubleNode<T> head, current, tail;
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
		this.tail = this.head;
		this.size = 1;
	}
	
	public void add(T data) {
		LinkedDoubleNode<T> toAdd = new LinkedDoubleNode<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.head = toAdd;
			this.tail = this.head;
			return;
		}
		//this.moveCurrent(this.size());
		this.head.setBackPointer(toAdd);
		toAdd.setFrontPointer(this.head);
		if(this.size == 1) {
			this.tail = toAdd;
		}
		this.head = toAdd;
	}
	
	public T poll() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		this.size--;
		if(this.size == 1) {
			T toReturn = this.tail.getData();
			this.head = null;
			this.tail = null;
			this.size--;
			return toReturn;
		}
		T toReturn = this.tail.getData();
		this.tail = this.tail.getBackPointer();
		this.tail.getFrontPointer().setBackPointer(null);
		this.tail.setFrontPointer(null);
		return toReturn;
	}
	
	public T peek() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		return this.tail.getData();
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return this.size;
	}
	
	public void moveCurrentClosest(int location) {
		if(location > this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location < this.size/2) {
			this.moveCurrentForwards(location);
			return;
		}
		this.moveCurrentBackwards(location);
	}
	
	public void moveCurrentForwards(int location) {
		System.out.println("Forwards");
		this.current = this.head;
		for(int j = 0; j < location && current.getFrontPointer() != null; j++, this.current = this.current.getFrontPointer());
	}
	
	public void moveCurrentBackwards(int location) {
		System.out.println("Backwards");
		this.current = this.tail;
		for(int j = this.size - 1; j > location && current.getBackPointer() != null; j--, this.current = this.current.getBackPointer());
	}
	
}
