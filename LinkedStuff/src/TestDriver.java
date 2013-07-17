
public class TestDriver {
	public static void main(String[] args) {
		LinkedDoubleStack<String> test = new LinkedDoubleStack<String>();
		
		for(int i = 20; i >= 0; i--) {
			test.push(i + "");
		}
		test.remove(21);
//		System.out.println(test.size());
//		test.push("hello");
//		System.out.println(test.size());
//		test.push("World");
//		System.out.println(test.size());
//		test.pushLast("World2");
//		System.out.println(test.size());
//		test.insert("Hello1", 2);
//		System.out.println(test.size());
//		test.set("teste" ,3);
////		System.out.println(test.size());
//		test.remove(0);
////		System.out.println(test.size());
//		System.out.println(test.popLast());
		
		while(test.size() > 0) {
			System.out.println(test.pop());
//			Thread.sleep(1000);
		}
	}
}
