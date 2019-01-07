import java.util.Scanner;

public class RockPaperScissor {
  public static void main(String[] args) {
    //Create a scanner
    Scanner scan = new Scanner(System.in);

    //Get player1 input
    System.out.print("Player 1:");
    string move1 = scan.next();

    //Type stuff to hide other player move
    for (int i = 0; i <20; i++) {
      System.out.println("-------------------");
    }

    //Get player2 input
    System.out.print("Player 2:");
    string move2 = scan.next();

    //output winner
    System.out.println(move1);
    System.out.println(move2);
    System.out.println(determineWinner(move1, move2));
    System.out.println(determineWinner("rock","paper"));
  }

  public static String determineWinner(String player1, String player2) {
    //Determine and return winner
    if ((player1 == "rock" && player2 == "scissors") || (player1 == "paper" && player2 == "rock") || (player1 == "scissors" && player2 == "paper")) {
      //player1 wins
      return "Player 1 wins";
    } else if ((player2 == "rock" && player1 == "scissors") || (player2 == "paper" && player1 == "rock") || (player2 == "scissors" && player1 == "paper")) {
      //player2 wins
      return "Player 2 wins";
    } else {
      return "ERROR \nInput may be invalid";
    }
  }
}
