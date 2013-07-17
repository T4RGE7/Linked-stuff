/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedCircleQueue<T> {
	
	private LinkedNode<T> head, current;
	
	public LinkedCircleQueue() {
		this.head = null;
		this.current = null;
	}
	
	public LinkedCircleQueue(T data) {
		this.head = new LinkedNode<T>(data);
		this.head.setFrontPointer(this.head);
	}
	
	public void add(T data) {
		LinkedNode<T> toPush = new LinkedNode<T>(data);
		if(this.isEmpty()) {
			toPush.setFrontPointer(toPush);
			this.head = toPush;
			return;
		}
		this.moveCurrent(this.size());
		this.current.setFrontPointer(toPush);
		toPush.setFrontPointer(this.head);
	//	this.head = toPush;
	}
	
	public T poll() {
		if(this.isEmpty()) {
			throw new NullPointerException();
		}
		T toReturn = this.head.getData();
		if(this.size() == 1) {
			this.head = null;
			return toReturn;
		}
		this.moveCurrent(this.size());
		this.current.setFrontPointer(this.head.getFrontPointer());
		this.head = this.current.getFrontPointer();
		return toReturn;
	}
	
	public T peek() {
		if(!this.isEmpty()) {
			throw new NullPointerException();
		}
		return this.head.getData();
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		this.current = this.head;
		int toReturn = 1;
		for(; current.getFrontPointer() != this.head; toReturn++, current = current.getFrontPointer());
		return toReturn;
	}
	
	public T remove(int location) {
		if(location == 0) {
			return poll();
		}
		moveCurrent(location - 1);
		T toReturn = this.current.getFrontPointer().getData();
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	public void insert(T data, int location) {
		if(location == 0) {
			LinkedNode<T> toPush = new LinkedNode<T>(data);
			if(this.isEmpty()) {
				toPush.setFrontPointer(toPush);
				this.head = toPush;
				return;
			}
			this.moveCurrent(this.size());
			this.current.setFrontPointer(toPush);
			toPush.setFrontPointer(this.head);
			this.head = toPush;
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
		for(int j = 0; j < location && current.getFrontPointer() != this.head; j++, this.current = this.current.getFrontPointer());
	
	}
}
