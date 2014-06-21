package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by morrista on 6/21/2014.
 */
public class Game {

    public String[] board = new String[9];
    public PrintStream out;
    public boolean player1Turn = true;

    public Game(PrintStream out) {
        this.out = out;
    }

    public void newGame() throws IOException {
        emptyboard();
        makeboard();
        playerMove();
    }

    public void emptyboard(){
        for(int i = 0; i < board.length; i++){
            board[i] = " ";
        }
    }

    public void playerMove() throws IOException {
        boolean winner = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayerTurn makeMove = new PlayerTurn(this, reader);
        int place = makeMove.placeOnBoard();
        if (place == -1){
            playerMove();
        } else {
            if (player1Turn){
                board[place - 1] = "X";
                Winner win = new Winner(this.board, "X");
                winner = win.isWinner();
                player1Turn = false;
            } else {
                board[place - 1] = "O";
                Winner win = new Winner(this.board, "O");
                winner = win.isWinner();
                player1Turn = true;
            }
            if (winner){
                out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                makeboard();
                if (player1Turn){
                    out.println("Player 2 has won the game!");
                } else {
                    out.println("Player 1 has won the game!");
                }
            } else {
                out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                makeboard();
                playerMove();
            }
        }

    }

    public void makeboard() {
        out.println(board[0].concat(" |").concat(board[1]).concat(" |").concat(board[2]));
        out.println("--------");
        out.println(board[3].concat(" |").concat(board[4]).concat(" |").concat(board[5]));
        out.println("--------");
        out.println(board[6].concat(" |").concat(board[7]).concat(" |").concat(board[8]));
    }
}
