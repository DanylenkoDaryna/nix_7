package ua.com.alevel.data;


import ua.com.alevel.utils.ChessGame;

public abstract class Figure{

    protected Chessman chessman;
    protected String startPosition;
    protected String currentPosition;
    protected Side side;

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

    private Chessman getChessman(){

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