package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {

    private Game game;
    private PrintStream mockStream;
    private BufferedReader mockReader;
    private Board mockBoard;
    private Player mockPlayer;
    @Before
    public void setUp(){
        mockBoard = mock(Board.class);
        mockPlayer = mock(Player.class);
        mockStream = mock(PrintStream.class);
        mockReader = mock(BufferedReader.class);
        game = new Game(mockReader, mockStream, mockBoard, mockPlayer);
    }

    @Test
    public void testNewGame() throws IOException {
        game.newGame();
        verify(mockBoard).emptyboard();
        verify(mockPlayer).makeMove(mockReader);
    }

}