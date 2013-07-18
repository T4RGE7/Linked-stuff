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
		LinkedCircleList<String> test = new LinkedCircleList<String>();
	
		for(int i = 20; i > 0; i--) {
			test.insertFirst(i + "");
		}
		
		System.out.println(test.peek(9));
		
		
		while(!test.isEmpty()) {
			System.out.println((test.remove()));
		}

	}

}
