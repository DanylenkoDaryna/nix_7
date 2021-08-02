package ua.com.alevel.data;

import ua.com.alevel.utils.ChessGame;


public class Bishop extends Figure{

    public Bishop(String startPosition, Side side){

        super(startPosition, side);
    }

    Bishop(){ }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){

            this.chessman=Chessman.WHITE_BISHOP;
        }else{

            this.chessman=Chessman.BLACK_BISHOP;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        return diagonalPath(srcRow, srcCol, destRow, destCol);
    }

    private boolean diagonalPath(int srcRow, int srcCol, int destRow, int destCol){

        if(Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)){

            int rowOffset=0;
            int colOffset=0;

            if(srcRow < destRow){
                rowOffset = 1;
            }else{
                rowOffset = -1;
            }

            if(srcCol < destCol){
                colOffset = 1;
            }else{
                colOffset = -1;
            }

            return isAnyFiguresOnYourWay(srcRow, srcCol, destRow, destCol, rowOffset, colOffset);
        }else{

            System.out.println("Bishop does not move that way..");
            return false;
        }
    }

    private boolean isAnyFiguresOnYourWay(int srcRow, int srcCol, int destRow,
                                                 int destCol, int rowOffset, int colOffset){

        for(int i=srcRow+rowOffset, j=srcCol+colOffset; i>=destRow; i+=rowOffset, j+=colOffset){

            if(ChessGame.board[i][j] != null){

                System.out.println("There are other figures on your way..");
                return false;
            }
        }
        this.isEnemyKingBeaten(destRow, destCol);
        return true;
    }
}
