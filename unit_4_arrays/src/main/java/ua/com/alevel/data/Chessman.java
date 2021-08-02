package ua.com.alevel.data;

public enum Chessman {

    WHITE_KING("\u2654"), WHITE_QUEEN("\u2655"), WHITE_BISHOP("\u2657"),
    WHITE_KNIGHT("\u2658"), WHITE_ROOK("\u2656"), WHITE_PAWN("\u2659"),

    BLACK_KING("\u265A"), BLACK_QUEEN("\u265B"), BLACK_BISHOP("\u265D"),
    BLACK_KNIGHT("\u265E"), BLACK_ROOK("\u265C"), BLACK_PAWN("\u265F");

    private String figureUnicode;

    Chessman(String figureUnicode){

        this.figureUnicode = figureUnicode;
    }

    public String getFigureUnicode(){

        return figureUnicode;
    }
}
