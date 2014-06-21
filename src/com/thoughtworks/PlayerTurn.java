package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by morrista on 6/21/2014.
 */
public class PlayerTurn {

    public boolean player1Turn;
    public String[] board = new String[9];
    public BufferedReader reader;
    public PrintStream out;


    public PlayerTurn(Game game, BufferedReader reader){
        this.player1Turn = game.player1Turn;
        this.board = game.board;
        this.reader = reader;
        this.out = game.out;
    }

    public int placeOnBoard() throws IOException {
        if(this.player1Turn){
            out.println("It's Player 1 Turn");
        } else {
            out.println("It's Player 2 Turn");
        }
        out.print("Please enter a place on the board (1-9): ");
        int place = Integer.parseInt(reader.readLine());
        if(place > 9 || place < 1){
            out.println("Please enter a number that is between 1-9");
            return -1;
        }
        if (board[place-1].equals(" ")){
            out.println("You have entered successfully entered a position");
            return place;
        } else {
            out.println("Please enter a position that isn't filled");
            return -1;
        }
    }
}
