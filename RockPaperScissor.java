import java.util.Scanner;

public class RockPaperScissor {
  public static void main(String[] args) {
    //Create a scanner
    Scanner scan = new Scanner(System.in);

    //Get player1

    //Type stuff to hide other player move

    //Get player2 input

    //output winner
    System.out.println(determineWinner("rock", "scissors"));
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
      return "ERROR \n Input may be invalid";
    }
  }
}
