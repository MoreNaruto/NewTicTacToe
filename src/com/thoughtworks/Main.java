package com.thoughtworks;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game tictactoe = new Game(System.out);
        tictactoe.newGame();
    }
}
