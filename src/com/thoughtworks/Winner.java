package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by morrista on 6/21/2014.
 */
public class Winner {
    private final static int THREE = 3;
    public String[] board = new String[9];
    public String boardPiece;
    private List<Integer> winner1 = new ArrayList<Integer>(Arrays.asList(1, 5, 9));
    private List<Integer> winner2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    private List<Integer> winner3 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
    private List<Integer> winner4 = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
    private List<Integer> winner5 = new ArrayList<Integer>(Arrays.asList(1, 4, 7));
    private List<Integer> winner6 = new ArrayList<Integer>(Arrays.asList(2, 5, 8));
    private List<Integer> winner7 = new ArrayList<Integer>(Arrays.asList(3, 6, 9));
    private List<Integer> winner8 = new ArrayList<Integer>(Arrays.asList(3, 5, 7));

    public Winner(String[] board, String boardPiece){
        this.board = board;
        this.boardPiece = boardPiece;
    }

    public boolean isWinner() {
        String threeInARow = boardPiece.concat(boardPiece).concat(boardPiece);
        if (win1(threeInARow) || win2(threeInARow) || win3(threeInARow) || win4(threeInARow)
                || win5(threeInARow) || win6(threeInARow) || win7(threeInARow)
                || win8(threeInARow)){
            return true;
        }
        return false;
    }

    private boolean win1(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner1.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win2(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner2.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win3(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner3.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win4(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner4.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win5(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner5.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win6(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner6.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win7(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner7.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }

    private boolean win8(String winnerString){
        String checkForThree = "";
        for (int i = 0; i < THREE; i++){
            checkForThree = checkForThree.concat(board[winner8.get(i)-1]);
        }
        if (checkForThree.equals(winnerString)){
            return true;
        } else {
            return false;
        }
    }
}
