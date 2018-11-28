import java.util.Scanner;

public class UserInputScanner{
	public static void main(String[] args){
		//Create Scanner object
		Scanner kin = new Scanner(System.in);

		//Ask for name and say hello
		System.out.print("What is your first name? ");
		String firstName = kin.nextLine();
		System.out.print("What is your last name? ");
		String lastName = kin.nextLine();
		System.out.println("Hello " + firstName + " " + lastName + ", it's nice to meet you!");

		//Ask for Address, City, State, and Zip
		System.out.print("What is street address? ");
		String address = kin.nextLine();
		System.out.print("What is your city? ");
		String city = kin.nextLine();
		System.out.print("What is your state? ");
		String state = kin.nextLine();
		System.out.print("What is your Zip code? ");
		int zip = Integer.parseInt(kin.nextLine());

		//Output Data about person
		System.out.println("\n" + firstName + " " + lastName);
		System.out.println(address);
		System.out.println(city + ", " + state + " " + zip );
	}
}
