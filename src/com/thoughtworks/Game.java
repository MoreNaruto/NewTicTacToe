package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by morrista on 6/21/2014.
 */
public class Game {

    public PrintStream out;
    public Board board;
    public Player player;
    public BufferedReader reader;

    public Game(BufferedReader reader, PrintStream out, Board board, Player player) {
        this.reader = reader;
        this.out = out;
        this.board = board;
        this.player = player;
    }

    public void newGame() throws IOException {
        board.emptyboard();
        player.makeMove(reader);
    }




}
