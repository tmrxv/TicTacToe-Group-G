import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ToDo (Prototype)
        // Implement logic
        // Instantiate Game instance
        // While (true): scan input for row and column
        // check if move legal
        // make move
        // check if game is over (break condition)

        Scanner scanner = new Scanner(System.in);
        while (true) {
            TicTacToe game = new TicTacToe();
            while (true) {
                game.printBoard();
                System.out.print("Row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("Column (0-2): ");
                int col = scanner.nextInt();

                if (game.makeMove(row, col)) {
                    if (game.checkForWin()) {
                        game.printBoard();
                        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                        break;
                    }
                    game.changePlayer();
                } else {
                    System.out.println("This move is not valid.");
                }

                if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a draw!");
                    break;
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}