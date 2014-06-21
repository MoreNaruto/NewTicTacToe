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
        out.println(boardPlaces[0].concat(" |").concat(boardPlaces[1]).concat(" |").concat(boardPlaces[2]));
        out.println("--------");
        out.println(boardPlaces[3].concat(" |").concat(boardPlaces[4]).concat(" |").concat(boardPlaces[5]));
        out.println("--------");
        out.println(boardPlaces[6].concat(" |").concat(boardPlaces[7]).concat(" |").concat(boardPlaces[8]));
    }
}
