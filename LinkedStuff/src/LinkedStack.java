/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedStack<T>{

	private LinkedNode<T> head, current;
	
	public LinkedStack() {
		this.head = null;
	}
	
	public LinkedStack(T data) {
		this.head = new LinkedNode<T>(data);
	}
	
	public void push(T data) {
		if(this.head == null) {
			this.head = new LinkedNode<T>(data);
		} else {
			LinkedNode<T> temp = new LinkedNode<T>(data);
			temp.setFrontPointer(this.head);
			this.head = temp;
		}
	}
	
	public T pop() {
		if(!this.isEmpty()) {
			T toReturn = this.head.getData();
			this.head = this.head.getFrontPointer();
			return toReturn;
		}
		throw new NullPointerException();
	}
	
	public T peek() {
		if(!this.isEmpty()) {
			return this.head.getData();
		}
		throw new NullPointerException();
	}
	
	public T remove(int location) {
		if(location == 0) {
			return pop();
		}
		moveCurrent(location - 1);
		T toReturn = this.current.getFrontPointer().getData();
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	public void insert(T data, int location) {
		if(location == 0) {
			this.push(data);
			return;
		}

		if(location > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		LinkedNode<T> toInsert = new LinkedNode<T>(data);
		moveCurrent(location - 1);

		toInsert.setFrontPointer(this.current.getFrontPointer());
		this.current.setFrontPointer(toInsert);
	}
	
	public void set(T data, int location) {
		if(location > this.size() || location < 0) {
			throw new IndexOutOfBoundsException();
		}

		this.moveCurrent(location);
		this.current.setData(data);
	}
	
	public void moveCurrent(int location) {
		if(location > this.size() || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		this.current = this.head;
		for(int j = 0; j < location && current.getFrontPointer() != null; j++, this.current = this.current.getFrontPointer());
	
	}
	
	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		/*LinkedNode<T>*/ this.current = this.head;
		int toReturn = 1;
		for(; this.current.getFrontPointer() != null; toReturn++, this.current = this.current.getFrontPointer());
		return toReturn;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
}
