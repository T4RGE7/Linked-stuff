/**
 * 
 * @author James Roberts jpr242
 *
 */
public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws EmptyListException{
		LinkedQueue<String> test = new LinkedQueue<String>();
	
		for(int i = 20; i > 0; i--) {
			test.enque(i + "");
		}
		
//		System.out.println(test.peek(18));
		
		
		while(!test.isEmpty()) {
			System.out.println((test.poll()));
		}

	}

}
