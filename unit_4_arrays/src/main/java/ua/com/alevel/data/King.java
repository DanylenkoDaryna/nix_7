package ua.com.alevel.data;

public class King extends Figure{


    public King(String startPosition, Side side){

        super(startPosition, side);
    }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){

            this.chessman=Chessman.WHITE_KING;
        }else{

            this.chessman=Chessman.BLACK_KING;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

                if (Math.abs(destRow - srcRow) == 1 & destCol==srcCol){

                    return moveIsValid (destRow, destCol);

                }else if(destRow==srcRow & Math.abs(destCol-srcCol) == 1){

                    return moveIsValid (destRow, destCol);

                }else if(Math.abs(destRow - srcRow) == 1 & Math.abs(destCol-srcCol) == 1){

                    return moveIsValid (destRow, destCol);

                }else return false;
    }

    private boolean moveIsValid(int destRow, int destCol){

        this.isEnemyKingBeaten(destRow, destCol);
        return true;
    }

}
