/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedNode<T> {
	
	private T data;
	private LinkedNode<T> frontPointer;

	public LinkedNode() {
		this.data = null;
		this.frontPointer = null;
	}
	
	public LinkedNode(T data) {
		this.data = data;
		this.frontPointer = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedNode<T> getFrontPointer() {
		return frontPointer;
	}

	public void setFrontPointer(LinkedNode<T> frontPointer) {
		this.frontPointer = frontPointer;
	}
	
}
