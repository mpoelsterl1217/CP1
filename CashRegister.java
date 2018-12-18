import java.util.Scanner;

public class CashRegister {
  public static void main(String[] args) {
    //Create Scanner object
    Scanner scan = new Scanner(System.in);

    //Welcome Message
    System.out.println("Welcome to the Change Generator");

    //Read Bill amount and payment
    System.out.println("\nPlease Enter the amount of a Bill");
    System.out.print("Bill: $");
    Double bill = scan.nextDouble();
    System.out.println("\nPlease Enter the amount Paid");
    System.out.print("Paid: $");
    Double payment = scan.nextDouble();

    //Calculate Change Total and running remainder
    Double changeTotal = payment - bill;
    Double remainder = changeTotal;

    //Calculate how many twenties
    int twenties = (int)(remainder / 20);
    remainder = remainder % 20;
    //Calculate how many tens
    int tens = (int)(remainder / 10);
    remainder = remainder % 10;
    //Calculate fives
    int fives = (int)(remainder / 5);
    remainder = remainder % 5;
    //Calculate singles
    int singles = (int)(remainder / 1);
    remainder = remainder % 1;
    //Calculate quarters
    int quarters = (int)(remainder / .25);
    remainder = remainder % .25;
    //Calculate dimes
    int dimes= (int)(remainder / .10);
    remainder = remainder % .1;
    //Calculate nickels
    int nickels = (int)(remainder / .05);
    remainder = remainder % .05;
    //Calculate pennies
    int pennies = (int)(remainder / .01);
    remainder = remainder % .01;

    //Try to fix rounding stuff
    changeTotal = Math.floor(changeTotal*100) / 100; //rounds out the .000000004 stuff
    Double total = (twenties*20.00) + (tens*10.00) + (fives*5.00) + (singles*1.00) + (quarters*.25) + (dimes*.10) + (nickels*.05) + (pennies*.01);
    total = Math.floor(total*100) / 100; //rounds out the .0000000003 thing messing with conditionals
    if (changeTotal > total) {
      //not enough pennies
      pennies += 1;
    } else if (changeTotal < total) {
      //too many pennies
      pennies -= 1;
    } else {
      //right amount of pennies
    }

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
