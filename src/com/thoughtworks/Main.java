package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] boardPlaces = new String[9];
        PrintStream out = System.out;
        Board board = new Board(out, boardPlaces);
        Player players = new Player(boardPlaces, board, new BufferedReader(new InputStreamReader(System.in)), out);
        Game tictactoe = new Game(out, board, players);
        tictactoe.newGame();
    }
}
