import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class HelloWorld {

	//ctrl + space for content assist in eclipse
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//what we are doing here is creating an object of Date class
		Date d = new Date();
		System.out.println(d);
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		int x = 10;
		
		float f = 99.99F;
		
		long l = 99999999999999L; //error
		
		int y = 9_99_999_999;
		
		//long vl = 99999999999999999999999999999999999999999999999999999L;
		
		int i = 10;
		
		
		LocalTime t = LocalTime.now();
		if(t.getHour() >= 0 && t.getHour() < 12)
			System.out.println("Good Morning!");
		else if(t.getHour() > 12 && t.getHour() < 16)
			System.out.println("Good Afternoon!");
		else if(t.getHour() >= 16 && t.getHour() <= 21)
			System.out.println("Good Evening!");
		else
			System.out.println("Good night!");
		
		
		LocalDate dd = LocalDate.now();
		DayOfWeek day = dd.getDayOfWeek();
		
		switch(day) {
		case MONDAY:
			System.out.println("start the servers");
		case TUESDAY:
			System.out.println("check the health of the running servers");
			break;
		case WEDNESDAY:
			System.out.println("run certain processes");
			break;
		default:
			System.out.println("perform backup");
		}
	
	
		for(int j=0; j<5; j++)
			System.out.println(j);
		
		int k = 0;
		while(k<5) {
			System.out.println(k);
			k++;
		}
		
		
		int jk = 0;
		do {
			System.out.println(jk);
			jk++;
		} while(jk < 5);
	}
}