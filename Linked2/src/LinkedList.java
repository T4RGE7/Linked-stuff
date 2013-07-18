/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedList<T> {

	protected Node<T> head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public LinkedList(T data) {
		this.head = new Node<T>(data);
	}
	
	//adds to front
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if(this.isEmpty()) {
			this.head = newNode;
			return;
		}
		newNode.setFrontPointer(this.head);
		this.head = newNode;
	}
	
	//removes from front
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.head.getData();
		this.head = this.head.getFrontPointer();
		return toReturn;
	}
	
	public void clear() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return true;
	}
	
}
