import java.util.Scanner;

public class CashRegister {
  public static void main(String[] args) {
    //Create Scanner object
    Scanner scan = new Scanner(System.in);

    //Read Bill amount and payment
    System.out.println("Please Enter the amount of a Bill")
    System.out.print("Bill: $");
    Double bill = scan.nextDouble();
    System.out.println("\nPlease Enter the amount Paid")
    System.out.print("Payment: $");
    Double payment = scan.nextDouble();

    //Calculate Change Total and running remainder
    Double changeTotal = payment - bill;
    Double remainder = changeTotal;

    //Calculate how many twenties
    int twenties = remainder / 20;
    remainder = remainder % 20;
    //Calculate how many tens
    int tens = remainder / 10;
    remainder = remainder % 10;
    //Calculate fives
    int fives = remainder / 5;
    remainder = remainder % 5;
    //Calculate singles
    int singles = remainder / 1;
    remainder = remainder % 1;
    //Calculate quarters
    int quarters = remainder / .25;
    remainder = remainder % .25;
    //Calculate dimes
    int dimes= remainder / .10;
    remainder = remainder % .1;
    //Calculate nickels
    int nickels = remainder / .05;
    remainder = remainder % .05;
    //Calculate pennies
    int pennies = remainder / .01;
    remainder = remainder % .01;
    //Output Change due and breakdown of change
    System.out.println("\nChange: $" + changeTotal);
    System.out.println("$20: " + twenties);
    System.out.println("$10: " + tens);
    System.out.println("$5: " + fives);
    System.out.println("$1: " + singles);
    System.out.println("$.25: " + quarters);
    System.out.println("$.10: " + dimes);
    System.out.println("$.05: " + nickels);
    System.out.println("$.01: " + pennies);
  }
}
