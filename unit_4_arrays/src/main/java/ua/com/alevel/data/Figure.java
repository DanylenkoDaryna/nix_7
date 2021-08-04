package ua.com.alevel.data;


import ua.com.alevel.utils.ChessGame;

public abstract class Figure{

    protected Chessman chessman;
    protected String startPosition;
    protected String currentPosition;
    protected Side side;

    public static final String INCORRECT_MOVE = "This figure doesn`t move like that..";
    public static final String INCORRECT_ATTACK = "This figure doesn`t beat like that..";
    public static final String ANOTHER_FIGURES_ON_YOUR_WAY = "There are another figures in your way..";

    Figure(String startPosition, Side side){

        this.startPosition = startPosition;
        this.currentPosition = startPosition;
        this.side = side;
        setChessman();
    }

    Figure(){ }

    public abstract boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol);

    void isEnemyKingBeaten(int destRow, int destCol){

        if(ChessGame.board[destRow][destCol] != null &&
                ChessGame.board[destRow][destCol].getChessman().name().endsWith("KING")){
            ChessGame.finishGame();
        }
    }

    @Override
    public String toString(){

        return getChessman().getFigureUnicode() ;

    }

    public Chessman getChessman(){

        return chessman;
    }

    protected abstract void setChessman();

    public String getStartPosition(){

        return startPosition;
    }

    public void setStartPosition(String startPosition){
        this.startPosition = startPosition;
    }

    public String getCurrentPosition(){

        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition){

        this.currentPosition = currentPosition;
    }

    public Side getSide(){

        return side;
    }

    public void setSide(Side side){

        this.side = side;
    }

}