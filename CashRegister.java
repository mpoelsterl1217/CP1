import java.util.Scanner;

public class CashRegister {
  public static void main(String[] args) {
    //Create Scanner object
    Scanner scan = new Scanner(System.in);

    //Read Bill amount and payment
    Double bill = scan.next();
    Double payment = scan.next();

    //Calculate Change Total and running remainder
    Double ChangeTotal = payment - bill;
    Double remainder = ChangeTotal;

    //Calculate how many twenties

    //Calculate how many tens

    //Calculate fives

    //Calculate singles

    //Calculate quarters

    //Calculate dimes

    //Calculate nickels

    //Calculate pennies

    //Output Change due and breakdown of change
  }
}
