/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedDoubleNode<T> extends LinkedNode<T>{
	
	private LinkedDoubleNode<T> backPointer;
	
	public LinkedDoubleNode() {
		this.backPointer = null;
		this.setBackPointer(null);
		this.setFrontPointer(null);
	}
	
	public LinkedDoubleNode(T data) {
		this.setData(data);
		this.setBackPointer(null);
		this.setFrontPointer(null);
	}

	public LinkedDoubleNode<T> getBackPointer() {
		return backPointer;
	}

	public void setBackPointer(LinkedDoubleNode<T> backPointer) {
		this.backPointer = backPointer;
	}

}
