/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleList<T> {

	protected DoubleNode<T> head;
	
	public LinkedDoubleList() {
		this.head = null;
	}
	
	public LinkedDoubleList(T data) {
		this.head = new DoubleNode<T>(data);
	}
	
	//adds to front
	public void add(T data) {
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		if(this.isEmpty()) {
			this.head = newNode;
			return;
		}
		newNode.setFrontPointer(this.head);
		this.head.setBackPointer(newNode);
		this.head = newNode;
	}
	
	//removes from front
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.head.getData();
		if(this.head.getFrontPointer() == null) {
			this.head = null;
			return toReturn;
		}
		this.head = (DoubleNode<T>)this.head.getFrontPointer();
		this.head.setBackPointer(null);
		return toReturn;
	}
	
	public void clear() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
}
