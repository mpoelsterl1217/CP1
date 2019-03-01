import java.util.Scanner;

public class RollDice {
  public static void main(String[] args) {
    //Create Scanner object
    Scanner in = new Scanner(System.in);

    System.out.println("Rolling two dice");
    char input = 'y';

    //Loop until user says to stop rolling
    while (input == 'y') {
      //Generate two dice rolls
      int die1 = (int) (Math.random()*7);
      int die2 = (int) (Math.random()*7);
      //output dice rolls
      System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", sum of two dice: " + (die1 + die2));
      //ask for input
      System.out.print("Would you like to roll again? (y/n) ");
      input = in.next().charAt(0);
    };
    System.out.println("Goodbye");
  }
}
