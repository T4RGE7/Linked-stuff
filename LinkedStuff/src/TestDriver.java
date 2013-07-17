
public class TestDriver {
	public static void main(String[] args) {
		LinkedQueue<String> test = new LinkedQueue<String>();
		System.out.println(test.size());
		test.add("hello");
		System.out.println(test.size());
		test.add("World");
		System.out.println(test.size());
		test.insert("Hello1", 2);
		System.out.println(test.size());
		test.remove(0);
		System.out.println(test.size());
		while(!test.isEmpty()) {
			System.out.println(test.poll());
		}
	}
}
