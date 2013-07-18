/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedDoubleCircleList<T> {

	protected DoubleNode<T> tail;
	
	public LinkedDoubleCircleList() {
		this.tail = null;
	}
	
	public LinkedDoubleCircleList(T data) {
		this.tail = new DoubleNode<T>(data);
		this.tail.setBackPointer(this.tail);
		this.tail.setFrontPointer(this.tail);
	}
	
	//adds to end
	public void add(T data) {
		DoubleNode<T> newNode = new DoubleNode<T>(data);
		if(this.isEmpty()) {
			this.tail = newNode;
			this.tail.setBackPointer(this.tail);
			this.tail.setFrontPointer(this.tail);
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
	
	//removes from the front
	public T remove() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		T toReturn = this.tail.getFrontPointer().getData();
		if(this.tail == this.tail.getFrontPointer()) {
			this.tail = null;
			return toReturn;
		}
		this.tail.setFrontPointer(this.tail.getFrontPointer().getFrontPointer());
		((DoubleNode<T>)(this.tail.getFrontPointer())).setBackPointer(this.tail);
		return toReturn;
	}
	
	public boolean isEmpty() {
		if(this.tail == null) {
			return true;
		}
		return false;
	}
}
