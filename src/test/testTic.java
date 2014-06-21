package test;

/**
 * Created by morrista on 6/21/2014.
 */
import com.thoughtworks.Game;
import com.thoughtworks.PlayerTurn;
import com.thoughtworks.Winner;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class testTic {

    private Game tictactoe;
    private PrintStream mockStream;
    private BufferedReader mockReader;
    private PlayerTurn playerTurn;
    private Winner winBoard;

    @Before
    public void setUp() {
        mockStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        tictactoe = new Game(mockStream);
        playerTurn = new PlayerTurn(tictactoe, mockReader);
    }

    @Test
    public void testEmptyBoard() throws IOException {
        tictactoe.newGame();
        verify(mockStream).println(" " + " |" + " " + " |" + " " + "\n--------\n" +
                " " + " |" + " " + " |" + " " + "\n--------\n" + " " + " |" + " " + " |" + " ");

    }

    @Test
    public void testUserInputTooBig() throws IOException {
        when(mockReader.readLine()).thenReturn("10");
        playerTurn.placeOnBoard();
        verify(mockStream).println("Please enter a number that is between 1-9");
    }

    @Test
    public void testUserInputTooSmall() throws IOException {
        when(mockReader.readLine()).thenReturn("-1");
        playerTurn.placeOnBoard();
        verify(mockStream).println("Please enter a number that is between 1-9");
    }

    @Test
    public void testBoardPlaceAlreadyOccupied() throws IOException {
        tictactoe.board[0] = "X";
        when(mockReader.readLine()).thenReturn("1");
        playerTurn.placeOnBoard();
        verify(mockStream).println("Please enter a position that isn't filled");
    }

    @Test
    public void testBoardPlacementSuccessful() throws IOException {
        tictactoe.emptyboard();
        when(mockReader.readLine()).thenReturn("1");
        playerTurn.placeOnBoard();
        verify(mockStream).println("You have entered successfully entered a position");
    }

    @Test
    public void testForNoWinner() {
        tictactoe.emptyboard();
        tictactoe.board[0] = "X";
        tictactoe.board[1] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), false);
    }

    @Test
    public void testForWin1() {
        tictactoe.emptyboard();
        tictactoe.board[0] = "X";
        tictactoe.board[4] = "X";
        tictactoe.board[8] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

    @Test
    public void testForWin2() {
        tictactoe.emptyboard();
        tictactoe.board[0] = "X";
        tictactoe.board[1] = "X";
        tictactoe.board[2] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);
    }

    @Test
    public void testForWin3() {
        tictactoe.emptyboard();
        tictactoe.board[3] = "X";
        tictactoe.board[4] = "X";
        tictactoe.board[5] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

    @Test
    public void testForWin4() {
        tictactoe.emptyboard();
        tictactoe.board[6] = "X";
        tictactoe.board[7] = "X";
        tictactoe.board[8] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

    @Test
    public void testForWin5() {
        tictactoe.emptyboard();
        tictactoe.board[0] = "X";
        tictactoe.board[3] = "X";
        tictactoe.board[6] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);
    }

    @Test
    public void testForWin6() {
        tictactoe.emptyboard();
        tictactoe.board[1] = "X";
        tictactoe.board[4] = "X";
        tictactoe.board[7] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

    @Test
    public void testForWin7() {
        tictactoe.emptyboard();
        tictactoe.board[2] = "X";
        tictactoe.board[5] = "X";
        tictactoe.board[8] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

    @Test
    public void testForWin8(){
        tictactoe.emptyboard();
        tictactoe.board[2] = "X";
        tictactoe.board[4] = "X";
        tictactoe.board[6] = "X";
        winBoard = new Winner(tictactoe.board, "X");
        assertEquals(winBoard.isWinner(), true);

    }

}
