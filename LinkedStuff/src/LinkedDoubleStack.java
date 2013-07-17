/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedDoubleStack<T> {

	private LinkedDoubleNode<T> head, current, tail;
	private int size;
	
	public LinkedDoubleStack() {
		this.head = null;
		this.current = null;
		this.tail = null;
		this.size = 0;
	}
	
	public LinkedDoubleStack(T data) {
		this.head = new LinkedDoubleNode<T>(data);
		this.current = null;
		this.tail = this.head;
		this.size = 1;
	}
	
	public void push(T data) {
		LinkedDoubleNode<T> toPush = new LinkedDoubleNode<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.head = toPush;
			this.tail = this.head;
			return;
		}
		//this.moveCurrent(this.size());
		this.head.setBackPointer(toPush);
		toPush.setFrontPointer(this.head);
		if(this.size == 1) {
			this.tail = toPush;
		}
		this.head = toPush;
	}
	
	public void pushFirst(T data) {
		push(data);
		return;
	}
	
	public void pushLast(T data) {
		if(this.isEmpty()) {
			push(data);
			return;
		}
		this.size++;
		LinkedDoubleNode<T> toPush = new LinkedDoubleNode<T>(data);
		this.tail.setFrontPointer(toPush);
		toPush.setBackPointer(this.tail);
		this.tail = toPush;
	}
	
	public T pop() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		
		if(this.size == 1) {
			T toReturn = this.head.getData();
			this.head = null;
			this.tail = null;
			this.size--;
			return toReturn;
		}
		this.size--;
		T toReturn = this.head.getData();
		this.head.getFrontPointer().setBackPointer(null);
		this.head = this.head.getFrontPointer();
		return toReturn;
	}
	
	public T popFirst() {
		return this.pop();
	}
	
	public T popLast() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		if(this.size == 1) {
			return this.pop();
		}
		this.size--;
		T toReturn = this.tail.getData();
		this.tail.getBackPointer().setFrontPointer(null);
		this.tail = this.tail.getBackPointer();
		return toReturn;
	}
	
	public T peek() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		return this.head.getData();
	}
	
	public T peekFirst() {
		return this.peek();
	}
	
	public T peekLast() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		return this.tail.getData();
	}
	
	public void insert(T data, int location) {
		if(location > this.size() || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			this.push(data);
			return;
		}
		if(location == this.size) {
			this.pushLast(data);
			return;
		}
		LinkedDoubleNode<T> toInsert = new LinkedDoubleNode<T>(data);
		this.moveCurrentClosest(location - 1);
		toInsert.setFrontPointer(this.current.getFrontPointer());
		this.current.setFrontPointer(toInsert);
		toInsert.setBackPointer(toInsert.getFrontPointer().getBackPointer());
		toInsert.getFrontPointer().setBackPointer(toInsert);
		this.size++;
		
	}
	
	public T remove(int location) {
		if(location > this.size() || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.pop();
		}
		if(location == this.size) {
			return this.popLast();
		}
		this.moveCurrentClosest(location - 1);
		T toReturn = this.current.getData();
		this.current.getBackPointer().setFrontPointer(this.current.getFrontPointer());
		this.current.getFrontPointer().setBackPointer(this.current.getBackPointer());
		this.current = null;
		this.size --;
		return toReturn;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	public int size() {
//		if(this.isEmpty()) {
//			return 0;
//		}
//		this.current = this.head;
//		int toReturn = 1;
//		for(; this.current.getFrontPointer() != null; this.current = this.current.getFrontPointer(), toReturn++);
//		return toReturn;
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
