package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by morrista on 6/21/2014.
 */
public class Player {

    public boolean player1Turn = true;
    public String[] boardPieces = new String[9];
    public BufferedReader reader;
    public PrintStream out;
    public Board board;


    public Player(String[] boardPieces, Board board, BufferedReader reader, PrintStream out){
        this.boardPieces = boardPieces;
        this.reader = reader;
        this.out = out;
        this.board = board;
    }

    public void playerMove() throws IOException {
        boolean winner;
        int place = placeOnBoard();
        if (place == -1){
            playerMove();
        } else {
            if (player1Turn){
                boardPieces[place - 1] = "X";
                Winner win = new Winner(this.boardPieces, "X");
                winner = win.isWinner();
                player1Turn = false;
            } else {
                boardPieces[place - 1] = "O";
                Winner win = new Winner(this.boardPieces, "O");
                winner = win.isWinner();
                player1Turn = true;
            }
            if (winner){
                out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                board.makeboard();
                if (player1Turn){
                    out.println("Player 2 has won the game!");
                } else {
                    out.println("Player 1 has won the game!");
                }
            } else {
                out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                board.makeboard();
                playerMove();
            }
        }

    }

    public int placeOnBoard() throws IOException {
        if(this.player1Turn){
            out.println("It's Player 1 Turn");
        } else {
            out.println("It's Player 2 Turn");
        }
        out.print("Please enter a place on the boardPlaces (1-9): ");
        int place = Integer.parseInt(reader.readLine());
        if(place > 9 || place < 1){
            out.println("\nPlease enter a number that is between 1-9\n");
            return -1;
        }
        if (boardPieces[place-1].equals(" ")){
            out.println("\nYou have entered successfully entered a position\n");
            return place;
        } else {
            out.println("\nPlease enter a position that isn't filled\n");
            return -1;
        }
    }
}
