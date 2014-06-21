package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] boardPlaces = new String[9];
        PrintStream out = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(out, boardPlaces);
        Player players = new Player(boardPlaces, board, reader, out);
        Game tictactoe = new Game(reader, out, board, players);
        tictactoe.newGame();
    }
}
