
public class StringDemo {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		String newstr = "";
		long ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				newstr += str.charAt(j);
		long ns2 = System.nanoTime();
		
		System.out.println(newstr);
		System.out.println("approx time taken " + (ns2 - ns1) + " nanoseconds");
		
		StringBuffer buffer = new StringBuffer();
		ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				buffer.append(str.charAt(j));
		ns2 = System.nanoTime();
		
		System.out.println(buffer);
		System.out.println("approx time taken " + (ns2 - ns1) + " nanoseconds");

		StringBuilder builder = new StringBuilder();
		ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				builder.append(str.charAt(j));
		ns2 = System.nanoTime();
		
		System.out.println(builder);
		System.out.println("approx time taken " + (ns2 - ns1) + " nanoseconds");
}
}
