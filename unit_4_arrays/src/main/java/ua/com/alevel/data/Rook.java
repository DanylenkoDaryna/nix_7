package ua.com.alevel.data;

import ua.com.alevel.utils.ChessGame;

public class Rook extends Figure{


    public Rook(String startPosition, Side side){

        super(startPosition, side);

    }

    public Rook(){ }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){

            this.chessman=Chessman.WHITE_ROOK;
        }else{

            this.chessman=Chessman.BLACK_ROOK;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        int offset;
        if(srcRow == destRow){

            if(srcCol < destCol){
                offset = 1;
            }else{
                offset = -1;
            }

            for(int j = srcCol + offset; j != destCol; j += offset){
                if(ChessGame.board[srcRow][j] != null){

                    System.out.println("There are another figures in your way");
                    return false;
                }
            }
            return moveIsValid (destRow, destCol);
        }else if(srcCol == destCol){

            if(srcRow < destRow){
                offset = 1;
            }else{
                offset = -1;
            }

            for(int i = srcRow + offset; i != destRow; i += offset){

                if(ChessGame.board[i][srcCol] != null){

                    System.out.println("There are another figures in your way");
                    return false;
                }
            }
            return moveIsValid (destRow, destCol);
        }
        else{
            System.out.println("Rook doesn`t move like that..");
            return false;
        }
    }

    private boolean moveIsValid(int destRow, int destCol){

        this.isEnemyKingBeaten(destRow, destCol);
        return true;
    }
}
