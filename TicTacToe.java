import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    String[] positions = new String[9];
		System.out.println("Welcome to Tic Tac Toe. You will be X and go first. Refer to the board as follows: ");
		System.out.println(" 1 | 2 | 3 \n----------- \n 4 | 5 | 6 \n----------- \n 7 | 8 | 9 ");
		outputBoardState(positions);
		runUserTurn(positions, scan);
		while (someoneHasWon(positions) == false || whoWon(positions) == " ") {
			runUserTurn(positions, scan);
		}
		System.out.println("Player " + whoWon(positions) + " won!");
  }
  public static boolean someoneHasWon(String[] positions) {
    //checks board state and returns a boolean
		//checks horizontals
		if (positions[0] == positions[1] && positions[1] == positions[2]) {
			return true;
		} else if (positions[3] == positions[4] && positions[4] == positions[5]) {
			return true;
		} else if (positions[6] == positions[7] && positions[7] == positions[8]) {
			return true;
		} else if (positions[0] == positions[3] && positions[3] == positions[6]) { //check verticals
			return true;
		} else if (positions[1] == positions[4] && positions[4] == positions[7]) {
			return true;
		} else if (positions[2] == positions[5] && positions[5] == positions[8]) {
			return true;
		} else if (positions[0] == positions[4] && positions[4] == positions[8]) { //check diagonals
			return true;
		} else if (positions[6] == positions[4] && positions[4] == positions[2]) {
			return true;
		} else {
			return false;
		}
  }
	public static String whoWon(String[] positions) {
		//checks horizontals
		if (positions[0] == positions[1] && positions[1] == positions[2]) {
			return positions[0];
		} else if (positions[3] == positions[4] && positions[4] == positions[5]) {
			return positions[3];
		} else if (positions[6] == positions[7] && positions[7] == positions[8]) {
			return positions[6];
		} else if (positions[0] == positions[3] && positions[3] == positions[6]) { //check verticals
			return positions[0];
		} else if (positions[1] == positions[4] && positions[4] == positions[7]) {
			return positions[1];
		} else if (positions[2] == positions[5] && positions[5] == positions[8]) {
			return positions[2];
		} else if (positions[0] == positions[4] && positions[4] == positions[8]) { //check diagonals
			return positions[0];
		} else if (positions[6] == positions[4] && positions[4] == positions[2]) {
			return positions[6];
		} else {
			return "ERROR";
		}

	}
	public static void outputBoardState(String[] positions) {
		for (int i = 0;i < positions.length; i++) {
			if (positions[i] == null) {
				positions[i] = " ";
			}
		}
		System.out.println(" " + positions[0] + " | " + positions [1] + " | " + positions[2] + " \n----------- \n " + positions[3] + " | " + positions [4] + " | " + positions[5] + " \n----------- \n " + positions[6] + " | " + positions [7] + " | " + positions[8] + "\n");
	}
	public static boolean moveIsValid(String[] positions, int cellNum) {
		if ((cellNum - 1) >= 0 && (cellNum - 1) <= 8) {
			if (positions[cellNum - 1] != "O" && positions[cellNum - 1] != "X" ) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	public static void runUserTurn(String[] positions, Scanner scan) {
    //outputs board and and takes in turn and updates board position
		//gets move
		System.out.println("What cell do you want to play in?");
		int cellInput = scan.nextInt();
		if (moveIsValid(positions, cellInput)) {
			positions[cellInput - 1] = "X";
		} else {
			System.out.println("Invalid Move. Choose another.");
			runUserTurn(positions, scan);
		}
		System.out.println("Your move: ");
		outputBoardState(positions);
		if (someoneHasWon(positions) == false) {
			runAITurn(positions, scan);
		} else if (whoWon(positions) == " ") {
			runAITurn(positions, scan);
		}
  }
	public static void runAITurn(String[] positions, Scanner scan) {
		int randomCell = (int)(Math.random()*8) + 1;
		if (moveIsValid(positions, randomCell)) {
			positions[randomCell - 1] = "O";
		} else {
			runAITurn(positions, scan);
		}
		System.out.println("Computer's move: ");
		outputBoardState(positions);
	}
}
