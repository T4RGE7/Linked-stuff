/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedCircleList<T> {

	protected Node<T> tail, current;
	private int size;
	
	public LinkedCircleList() {
		this.tail = null;
		this.current = null;
		this.size = 0;
	}
	
	public LinkedCircleList(T data) {
		this.tail = new Node<T>(data);
		this.tail.setFrontPointer(this.tail);
		this.current = null;
		this.size = 1;
	}
	
	//adds to end
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.tail = newNode;
			this.tail.setFrontPointer(this.tail);
			return;
		}
		newNode.setFrontPointer(this.tail.getFrontPointer());
		this.tail.setFrontPointer(newNode);
		this.tail = newNode;
	}
	
	//adds to end
	public void insertLast(T data) {
		this.insert(data);
	}
	
	//adds to front
	public void insertFirst(T data) {
		if(this.isEmpty()) {
			this.insert(data);
			return;
		}
		Node<T> newNode = new Node<T>(data);
		newNode.setFrontPointer(this.tail.getFrontPointer());
		this.tail.setFrontPointer(newNode);
		this.size++;
	}
	
	//adds to location
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
		Node<T> newNode = new Node<T>(data);
		this.moveCurrentForwards(location - 1);
		newNode.setFrontPointer(this.current.getFrontPointer());
		this.current.setFrontPointer(newNode);
		this.size++;
	}
	
	//removes first
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.tail.getFrontPointer().getData();
		this.size--;
		if(this.tail == this.tail.getFrontPointer()) {
			this.tail = null;
			return toReturn;
		}
		this.tail.setFrontPointer(this.tail.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	//removes first
	public T removeFirst() throws EmptyListException {
		return this.remove();
	}
	
	//removes last
	public T removeLast() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(this.size == 1) {
			return this.remove();
		}
		this.size--;
		T toReturn = this.tail.getData();
		this.moveCurrentForwards(this.size);
		this.current.setFrontPointer(this.tail.getFrontPointer());
		this.tail = this.current;
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
		this.size--;
		this.moveCurrentForwards(location);
		T toReturn = this.current.getFrontPointer().getData();
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	//peeks first
	public T peek() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.tail.getFrontPointer().getData();
	}
	
	//peeks first
	public T peekFirst() throws EmptyListException{
		return this.peek();
	}
	
	//peeks last
	public T peekLast() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.tail.getData();
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
			return this.peek();
		}
		if(location == this.size - 1) {
			return this.peekLast();
		}
		this.moveCurrentForwards(location + 1);
		return this.current.getData();
	}
	
	public void clear() {
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if(this.tail == null) {
			return true;
		}
		return false;
	}
	
	protected void moveCurrentForwards(int location) {
//		System.out.println("Forwards");
		this.current = this.tail;
		for(int j = 0; j < location && current.getFrontPointer() != this.tail; j++, this.current = this.current.getFrontPointer());
	}
	
}
