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
		LinkedDoubleCircleList<String> test = new LinkedDoubleCircleList<String>();
		test.add("hello");
		test.add("world");
		test.add("two");
		
		while(!test.isEmpty()) {
			System.out.println((test.remove()));
		}

	}

}
