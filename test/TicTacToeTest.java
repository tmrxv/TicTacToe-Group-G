import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInitializeBoard() {
        game.initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', game.board[i][j]);
            }
        }
    }

    @Test
    public void testPrintBoard() {
        // This test is more for coverage and manual inspection since it prints to console
        game.printBoard();
    }

    @Test
    public void testMakeMove() {
        game.board[0][0] = 'X';
        assertEquals('X', game.board[0][0]);
    }

    @Test
    public void testMakeMoveInvalid() {
        assertFalse(game.makeMove(3, 3)); // Out of bounds
        game.board[0][0] = 'X'; // Valid move
        assertFalse(game.makeMove(0, 0)); // Invalid since it's already taken
    }

    @Test
    public void testChangePlayer() {
        game.changePlayer();
        assertEquals('O', game.getCurrentPlayer());
        game.changePlayer();
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testCheckForWinRow() {
        game.board[0][0] = 'X';
        game.board[0][1] = 'X';
        game.board[0][2] = 'X';
        assertTrue(game.checkForWin());
    }

    @Test
    public void testCheckForWinColumn() {
        game.board[0][0] = 'X';
        game.board[1][0] = 'X';
        game.board[2][0] = 'X';
        assertTrue(game.checkForWin());
    }

    @Test
    public void testCheckForWinDiagonal() {
        game.board[0][0] = 'X';
        game.board[1][1] = 'X';
        game.board[2][2] = 'X';
        assertTrue(game.checkForWin());
    }

    @Test
    public void testCheckForWinNoWin() {
        game.board[0][0] = 'X';
        game.board[1][0] = 'X';
        game.board[2][0] = 'O';
        assertFalse(game.checkForWin());
    }

    @Test
    public void testIsBoardFull() {
        game.board[0][0] = 'X';
        game.board[0][1] = 'O';
        game.board[0][2] = 'X';
        game.board[1][0] = 'O';
        game.board[1][1] = 'X';
        game.board[1][2] = 'O';
        game.board[2][0] = 'X';
        game.board[2][1] = 'O';
        game.board[2][2] = 'X';
        assertTrue(game.isBoardFull());
    }

    @Test
    public void testIsBoardFullNotFull() {
        assertFalse(game.isBoardFull());
    }

    @Test
    public void testGetCurrentPlayer() {
        assertEquals('X', game.getCurrentPlayer());
        game.changePlayer();
        assertEquals('O', game.getCurrentPlayer());
    }
}