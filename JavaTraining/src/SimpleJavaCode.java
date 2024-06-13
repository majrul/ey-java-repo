import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Scanner;

public class SimpleJavaCode {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//i need to take user input
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name = s.nextLine();
		
		System.out.println("Hello " + name);
		
		double no = Math.sqrt(9);
		
		//LocalDate d = LocalDate.now();
		LocalDate d = LocalDate.of(2020, 6, 13);
		System.out.println(d.getDayOfWeek());
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		String pw  = new String(md.digest("123456".getBytes()));
		System.out.println(pw);
	}
}
