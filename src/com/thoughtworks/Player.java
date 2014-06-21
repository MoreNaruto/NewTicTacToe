package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by morrista on 6/21/2014.
 */
public class Player {

    public boolean isWinner;
    public int place;
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

    public void makeMove(BufferedReader reader) throws IOException {
        place = placeOnBoard(reader);
        playerMove();
    }

    public void playerMove() throws IOException {

        if (place == -1){
            out.println("Your input was incorrect! \n");
            this.makeMove(reader);
        } else {
            if (player1Turn){
                boardPieces[place - 1] = "X";
                Winner win = new Winner(this.boardPieces, "X");
                isWinner = win.isWinner();
                player1Turn = false;
            } else {
                boardPieces[place - 1] = "O";
                Winner win = new Winner(this.boardPieces, "O");
                isWinner = win.isWinner();
                player1Turn = true;
            }
            if (isWinner){
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
                makeMove(reader);
            }
        }

    }

    public int placeOnBoard(BufferedReader reader) throws IOException {
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
