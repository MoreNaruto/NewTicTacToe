package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by thomasmorris on 6/21/14.
 */
public class PlayerTest {

    private BufferedReader mockReader;
    private Board board;
    private String[] boardPieces;
    private PrintStream mockStream;
    private Player player;

    @Before
    public void setUp(){
        mockReader = mock(BufferedReader.class);
        mockStream = mock(PrintStream.class);
        boardPieces = new String[9];
        board = new Board(mockStream, boardPieces);
        player = new Player(boardPieces, board, mockReader, mockStream);
    }

    @Test
    public void testUserInputTooBig() throws IOException {
        when(mockReader.readLine()).thenReturn("10");
        player.placeOnBoard(mockReader);
        verify(mockStream).println("\nPlease enter a number that is between 1-9\n");
    }

    @Test
    public void testUserInputTooSmall() throws IOException {
        when(mockReader.readLine()).thenReturn("-1");
        player.placeOnBoard(mockReader);
        verify(mockStream).println("\nPlease enter a number that is between 1-9\n");
    }

    @Test
    public void testBoardPlaceAlreadyOccupied() throws IOException {
        boardPieces[0] = "X";
        when(mockReader.readLine()).thenReturn("1");
        player.placeOnBoard(mockReader);
        verify(mockStream).println("\nPlease enter a position that isn't filled\n");
    }

    @Test
    public void testBoardPlacementSuccessful() throws IOException {
        board.emptyboard();
        when(mockReader.readLine()).thenReturn("1");
        player.placeOnBoard(mockReader);
        verify(mockStream).println("\nYou have entered successfully entered a position\n");
    }

    @Test
    public void testPlacementErrorRedo() throws IOException {

        when(mockReader.readLine()).thenReturn("-1");
        player.makeMove(mockReader);
        verify(mockStream).println("Your input was incorrect! \n");
        
    }





}
