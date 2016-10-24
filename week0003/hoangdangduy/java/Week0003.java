import java.util.HashMap;
import java.util.Scanner;

public class Week0003 {
	public static void main(String[] args) {
		HashMap<String, Double> accounts = new HashMap<>();
		Process process = new Process();
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
	    		accounts = process.process(sc.nextLine(), accounts);
		}
	    	sc.close();
	}
}
