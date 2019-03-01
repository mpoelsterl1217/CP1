import java.util.Scanner;

public class RollDice {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Rolling two dice");
    char input = 'y';
    while (input == 'y') {
      int die1 = (int) (Math.random()*7);
      int die2 = (int) (Math.random()*7);
      System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", sum of two dice: " + (die1 + die2));
      System.out.print("Would you like to roll again? (y/n)");
      input = in.next().charAt(0);
      System.out.println(input);
    };
  }
}
