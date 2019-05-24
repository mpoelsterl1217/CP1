import java.util.Scanner;

public class ArrayGame {
  static int xX = 0;
  static int xY = 0;
  static int goalY = (int) (Math.random()*4);
  static int goalX = (int) (Math.random()*4);
  static char[][] board = {{'x', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'O'}};
  static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    if (board[goalY][goalX] != 'x') {
      board[goalY][goalX] = '*';
    } else {
      goalY = goalY + ((int) Math.random()*3) + 1;
      goalX = goalX + ((int) Math.random()*3) + 1;
      board[goalY][goalX] = '*';
    }
    System.out.println("Welcome to the Array Game!  Move your sprite \"x\" to the \"*\" to win. \n\nInitial Board:");
    while (playerHasWon() != true) {
      printBoard();
      runUserTurn();
    }
    System.out.println("\nCongrats, you have won!");
  }
  public static boolean isValidMove(String direction) {
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
    System.out.print("Which direction would you like to move? ");
    String move = scan.nextLine();
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
      System.out.println("Invalid Move");
    }
  }
  public static void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j]);
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }
  public static boolean playerHasWon() {
    if (xY == goalY && xX == goalX) {
      return true;
    }
    return false;
  }
}
