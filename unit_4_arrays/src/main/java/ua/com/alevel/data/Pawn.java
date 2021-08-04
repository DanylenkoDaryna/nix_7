package ua.com.alevel.data;

import ua.com.alevel.utils.ChessGame;


public class Pawn extends Figure{

    public Pawn(String startPosition,  Side side){

        super(startPosition, side);
    }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){

            this.chessman=Chessman.WHITE_PAWN;
        }else{

            this.chessman=Chessman.BLACK_PAWN;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        if(srcCol == destCol){

            String originPosition = ChessGame.board[srcRow][srcCol].startPosition;
            int originRow = ChessGame.getRowFrom(originPosition);
            int originCol = ChessGame.getColFrom(originPosition);

            if (srcRow == originRow & srcCol == originCol){

                return (Math.abs(destRow - srcRow) == 1 | Math.abs(destRow - srcRow) == 2);

            }else if(Math.abs(destRow - srcRow) == 1 ){

                return moveIsValid (destRow, destCol);

            }else if(ChessGame.board[destRow][destCol]!=null){

                System.out.println(INCORRECT_ATTACK);
                return false;
            }
        } else return isDiagonalMoveValid(srcRow, srcCol, destRow, destCol);

        return false;

    }


    private boolean isDiagonalMoveValid(int srcRow, int srcCol, int destRow, int destCol){

        if (ChessGame.board[destRow][destCol].getSide().equals(ChessGame.enemySide)){

            if(ChessGame.currentSide.equals(ChessGame.userSide) & srcRow>srcCol & Math.abs(srcCol-destCol)==1){

                return moveIsValid (destRow, destCol);

            }else if(ChessGame.currentSide.equals(ChessGame.enemySide) & srcRow<srcCol & Math.abs(srcCol-destCol)==1){

                return moveIsValid (destRow, destCol);

            }else{
                System.out.println(INCORRECT_ATTACK);
                return false;
            }
        }else{
            System.out.println(INCORRECT_ATTACK);
            return false;
        }
    }

    private boolean moveIsValid(int destRow, int destCol){

        this.isEnemyKingBeaten(destRow, destCol);
        return true;
    }
}
