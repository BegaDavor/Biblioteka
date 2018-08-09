import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteka {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> users = new ArrayList<>();
	static ArrayList<Books> books = new ArrayList<>();
	
	public static double isDouble() { // handle exception za double brojeve
		while (true) {
			try {
				return input.nextDouble();
			}
			catch (InputMismatchException e) {
				input.next();
				System.out.println("Vas unos nije dobar. Probajte ponovo: ");
			}
		}
	}
	
	public static int isInteger() { // handle exception za integer brojeve
		while (true) {
			try {
				return input.nextInt();
			}
			catch (InputMismatchException e) {
				input.next();
				System.out.println("Vas unos nije dobar. Probajte ponovo: ");
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
