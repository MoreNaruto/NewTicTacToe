package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream mockStream;
    private String[] boardPieces;

    @Before
    public void setUp(){
        mockStream = mock(PrintStream.class);
        boardPieces = new String[9];
        board = new Board(mockStream, boardPieces);
    }

    @Test
    public void testEmptyBoard(){
        board.emptyboard();
        verify(mockStream).println(
                "  |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  " );
    }
    @Test
    public void testMakeBoard(){
        board.emptyboard();
        boardPieces[0] = "X";
        boardPieces[5] = "X";
        boardPieces[3] = "O";
        board.makeboard();
        verify(mockStream).println(
            " " + boardPieces[0] + "| " + boardPieces[1] +"| " + boardPieces[2] +"\n" +
            "--------\n" +
            " " + boardPieces[3] + "| " + boardPieces[4] +"| " + boardPieces[5] +"\n" +
            "--------\n" +
            " " + boardPieces[6] + "| " + boardPieces[7] +"| " + boardPieces[8]);
    }
}