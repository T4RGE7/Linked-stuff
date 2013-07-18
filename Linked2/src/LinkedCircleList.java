/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedCircleList<T> {

	protected Node<T> tail;
	
	public LinkedCircleList() {
		this.tail = null;
	}
	
	public LinkedCircleList(T data) {
		this.tail = new Node<T>(data);
		this.tail.setFrontPointer(this.tail);
	}
	
	//adds to end
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(this.isEmpty()) {
			this.tail = newNode;
			this.tail.setFrontPointer(this.tail);
			return;
		}
		newNode.setFrontPointer(this.tail.getFrontPointer());
		this.tail.setFrontPointer(newNode);
		this.tail = newNode;
	}
	
	//removes first
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.tail.getFrontPointer().getData();
		if(this.tail == this.tail.getFrontPointer()) {
			this.tail = null;
			return toReturn;
		}
		this.tail.setFrontPointer(this.tail.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	public void clear() {
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if(this.tail == null) {
			return true;
		}
		return true;
	}
}
