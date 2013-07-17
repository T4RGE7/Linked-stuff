/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedDoubleNode<T> {
	
	private LinkedDoubleNode<T> backPointer, frontPointer;
	private T data;
	
	public LinkedDoubleNode() {
		this.data = null;
		this.backPointer = null;
		this.backPointer = null;
	}
	
	public LinkedDoubleNode(T data) {
		this.data = data;
		this.backPointer = null;
		this.backPointer = null;
	}

	public LinkedDoubleNode<T> getBackPointer() {
		return backPointer;
	}

	public void setBackPointer(LinkedDoubleNode<T> backPointer) {
		this.backPointer = backPointer;
	}

	public LinkedDoubleNode<T> getFrontPointer() {
		return frontPointer;
	}

	public void setFrontPointer(LinkedDoubleNode<T> frontPointer) {
		this.frontPointer = frontPointer;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
