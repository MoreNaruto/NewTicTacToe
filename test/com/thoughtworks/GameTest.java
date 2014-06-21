package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game;
    private PrintStream mockStream;
    private Board mockBoard;
    private Player mockPlayer;
    @Before
    public void setUp(){
        mockBoard = mock(Board.class);
        mockPlayer = mock(Player.class);
        mockStream = mock(PrintStream.class);
        game = new Game(mockStream, mockBoard, mockPlayer);
    }

    @Test
    public void testNewGame() throws IOException {
        BufferedReader mockReader = mock(BufferedReader.class);
        game.newGame();
        verify(mockBoard).emptyboard();
        verify(mockPlayer).playerMove();
    }

}