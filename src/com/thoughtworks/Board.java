package com.thoughtworks;

import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/21/14.
 */
public class Board {

    private PrintStream out;
    private String[] boardPlaces;

    public Board(PrintStream out, String[] boardPlaces){
        this.out = out;
        this.boardPlaces = boardPlaces;
    }

    public void emptyboard(){
        out.println(
                "  |  |  \n" +
                "--------\n" +
                "  |  |  \n" +
                "--------\n" +
                "  |  |  " );
        for (int i = 0; i < boardPlaces.length; i++){
            boardPlaces[i] = " ";
        }
    }

    public void makeboard() {
        out.println(
                " " + boardPlaces[0] + "| " + boardPlaces[1] +"| " + boardPlaces[2] +"\n" +
                "--------\n" +
                " " + boardPlaces[3] + "| " + boardPlaces[4] +"| " + boardPlaces[5] +"\n" +
                "--------\n" +
                " " + boardPlaces[6] + "| " + boardPlaces[7] +"| " + boardPlaces[8]);
    }
}
