
public class Calculator {

	public void add(int x, int y) {
		System.out.println(x + y);
	}

	public static void sub(int x, int y) {
		System.out.println(x - y);
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		for(int i=0; i<1000; i++)
			c.add(10, 20);
		
		for(int i=0; i<1000; i++)
			Calculator.sub(10, 20);
	}
}
