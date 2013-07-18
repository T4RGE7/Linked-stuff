/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleCircleList<T> {

	protected DoubleNode<T> tail, head, current;
	private int size;
	
	public LinkedDoubleCircleList() {
		this.tail = this.head = this.current = null;
		this.size = 0;
	}
	
	public LinkedDoubleCircleList(T data) {
		this.tail = new DoubleNode<T>(data);
		this.tail.setBackPointer(this.tail);
		this.tail.setFrontPointer(this.tail);
		this.head = this.tail;
		this.current = null;
		this.size = 1;
	}
	
	//adds to end
	public void insert(T data) {
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.tail = newNode;
			this.tail.setBackPointer(this.tail);
			this.tail.setFrontPointer(this.tail);
			this.head = this.tail;
			return;
		}
		newNode.setBackPointer(this.tail);
		newNode.setFrontPointer(this.tail.getFrontPointer());
		this.tail.setFrontPointer(newNode);
		((DoubleNode<T>)(newNode.getFrontPointer())).setBackPointer(newNode);
		this.tail = newNode;
//		this.tail.setFrontPointer(newNode);
//		newNode.setBackPointer(this.tail);
//		newNode.setFrontPointer(this.tail.getFrontPointer());
//		((DoubleNode<T>)(newNode.getFrontPointer())).setBackPointer(newNode);
//		this.tail = newNode;
	}
	
	//adds to front
	public void insertFirst(T data) {
		if(this.isEmpty()) {
			this.insert(data);
			return;
		}
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		newNode.setFrontPointer(this.head);
		this.head.setBackPointer(newNode);
		newNode.setBackPointer(this.tail);
		this.tail.setFrontPointer(newNode);
		this.head = newNode;
		this.size++;
	}
	
	//adds to end
	public void insertLast(T data) {
//		if(this.isEmpty()) {
//			this.insert(data);
//			return;
//		}
//		DoubleNode<T> newNode = new DoubleNode<T>(data);
//		newNode.setFrontPointer(this.head);
//		this.head.setFrontPointer(newNode);
//		newNode.setBackPointer(this.tail);
//		this.tail.setFrontPointer(newNode);
//		this.tail = newNode;
//		this.size++;
		this.insert(data);
	}
	
	//inserts at location
	public void insert(T data, int location) {
		if(location > this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			this.insertFirst(data);
			return;
		}
		if(location == this.size) {
			this.insert(data);
			return;
		}
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		this.moveCurrentClosest(location - 1);
		newNode.setFrontPointer(this.current.getFrontPointer());
		((DoubleNode<T>)(newNode.getFrontPointer())).setBackPointer(newNode);
		newNode.setBackPointer(this.current);
		this.current.setFrontPointer(newNode);
		this.size++;
	}
	
	//removes from the front
	public T remove() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.head.getData();
		this.size--;
		if(this.head == this.head.getFrontPointer()) {
			this.head = null;
			this.tail = null;
			return toReturn;
		}
		this.head = (DoubleNode<T>) this.head.getFrontPointer();
		this.head.setBackPointer(this.tail);
		this.tail.setFrontPointer(this.head);
		return toReturn;
/*		T toReturn = this.tail.getFrontPointer().getData();
		if(this.tail == this.tail.getFrontPointer()) {
			this.tail = null;
			return toReturn;
		}
		this.tail.setFrontPointer(this.tail.getFrontPointer().getFrontPointer());
		((DoubleNode<T>)(this.tail.getFrontPointer())).setBackPointer(this.tail);
		return toReturn; // with tail only*/
	}
	
	//removes from the front
	public T removeFirst() throws EmptyListException {
		return this.remove();
	}
	
	//removes from the end
	public T removeLast() throws EmptyListException {
		if(this.size == 1) {
			return this.remove();
		}
		T toReturn = this.tail.getData();
		this.tail = this.tail.getBackPointer();
		this.tail.setFrontPointer(this.head);
		this.head.setBackPointer(this.tail);
		this.size--;
		return toReturn;
	}
	
	//removes from location
	public T remove(int location) throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location >= this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.remove();
		}
		if(location == this.size - 1) {
			return this.removeLast();
		}
		this.moveCurrentClosest(location - 1);
		T toReturn = this.current.getFrontPointer().getData();
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		((DoubleNode<T>)(this.current.getFrontPointer())).setBackPointer(this.current);
		this.size--;
		return toReturn;
	}
	
	//peeks at end
	public T peek() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.tail.getData();
	}
	
	//peeks at end
	public T peekLast() throws EmptyListException {
		return this.peek();
	}
	
	//peeks fisrt
	public T peekFirst() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.head.getData();
	}
	
	//peeks at location
	public T peek(int location) throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location >= this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.peekFirst();
		}
		if(location == this.size - 1) {
			return this.peek();
		}
		this.moveCurrentClosest(location);
		return this.current.getData();
	}
	
	public boolean isEmpty() {
		if(this.tail == null) {
			return true;
		}
		return false;
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
		for(int j = 0; j < location && current.getFrontPointer() != this.head; j++, this.current = (DoubleNode<T>) this.current.getFrontPointer());
	}
	
	public void moveCurrentBackwards(int location) {
		System.out.println("Backwards");
		this.current = this.tail;
		for(int j = this.size - 1; j > location && current.getBackPointer() != this.tail; j--, this.current = this.current.getBackPointer());
	}
}
