/**
 * 
 * @author James Roberts jpr242
 *
 * 
 */
public class LinkedCircleDoubleStack<T> {

	private LinkedDoubleNode<T> head, current, tail;
	private int size;
	
	public LinkedCircleDoubleStack() {
		this.head = null;
		this.current = null;
		this.tail = null;
		this.size = 0;
	}
	
	public LinkedCircleDoubleStack(T data) {
		this.head = new LinkedDoubleNode<T>(data);
		this.current = null;
		this.tail = this.head;
		this.size = 1;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return this.size;
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
		for(int j = 0; j < location && current.getFrontPointer() != null; j++, this.current = this.current.getFrontPointer());
	}
	
	public void moveCurrentBackwards(int location) {
		System.out.println("Backwards");
		this.current = this.tail;
		for(int j = this.size - 1; j > location && current.getBackPointer() != null; j--, this.current = this.current.getBackPointer());
	}
	
}
