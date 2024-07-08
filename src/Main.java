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

                game.makeMove(row, col);
            }
        }
        //scanner.close();
    }
}