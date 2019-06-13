import java.util.Scanner;

public class ArrayGame {
	//Vars used throughout that hold the coords of the player and asterisk, also the board as a 2d array
  static int xX = 0;
  static int xY = 0;
  static int goalY = (int) (Math.random()*4);
  static int goalX = (int) (Math.random()*4);
  static char[][] board = { {'x', 'O', 'O', 'O'},
                          	{'O', 'O', 'O', 'O'},
                            {'O', 'O', 'O', 'O'},
                            {'O', 'O', 'O', 'O'}};
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
		//Places the asterisk randomly
    if (board[goalY][goalX] != 'x') {
      board[goalY][goalX] = '*';
    } else {
      goalY = goalY + ((int) Math.random()*3) + 1;
      goalX = goalX + ((int) Math.random()*3) + 1;
      board[goalY][goalX] = '*';
    }
		//Welcome message
    System.out.println("Welcome to the Array Game!  Move your sprite \"x\" to the \"*\" to win. \n\nInitial Board:");
		//Loop to keep running turns until the player has won
		while (playerHasWon() != true) {
      printBoard();
      runUserTurn();
    }
		//Win message
    System.out.println("\nCongrats, you have won!");
  }
  public static boolean isValidMove(String direction) {
		//Method that takes in the direction of a move and checks if it is valid for the player
    if (direction.equals("up")){
      if (xY - 1 < 0) {
        return false;
      }
      return true;
    } else if(direction.equals("down")){
      if (xY + 1 > 3) {
        return false;
      }
      return true;
    } else if (direction.equals("left")){
      if (xX - 1 < 0) {
        return false;
      }
      return true;
    } else if (direction.equals("right")){
      if (xX + 1 > 3) {
        return false;
      }
      return true;
    }
    return false;
  }
  public static void runUserTurn() {
		//Method for the user turn
		//Ask for and recieve input
    System.out.print("Which direction would you like to move? ");
    String move = scan.nextLine();
		//Check validity of move and execute move
    if (isValidMove(move) == true) {
      board[xY][xX] = 'O';
      if (move.equals("up")) {
        xY = xY - 1;
      } else if (move.equals("down")) {
        xY = xY + 1;
      } else if (move.equals("left")) {
        xX = xX - 1;
      } else if (move.equals("right")) {
        xX = xX + 1;
      }
      board[xY][xX] = 'x';
    } else {
			//Invalid move message
      System.out.println("Invalid Move");
    }
  }
  public static void printBoard() {
		//Method that loops through the 2d board array and prints it nicely formatted
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }
  public static boolean playerHasWon() {
		//Method that checks if the player has won by checking if the coords of the x and asterisk are the same
    if (xY == goalY && xX == goalX) {
      return true;
    }
    return false;
  }
}
