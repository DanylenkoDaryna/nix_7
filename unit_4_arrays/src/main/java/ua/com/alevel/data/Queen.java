package ua.com.alevel.data;


public class Queen extends Figure{

    public Queen(String startPosition, Side side){

        super(startPosition,  side);
    }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){

            this.chessman=Chessman.WHITE_QUEEN;
        }else{

            this.chessman=Chessman.BLACK_QUEEN;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        return new Rook().isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol) ||
                new Bishop().isMoveValidByFigureRules(srcRow, srcCol, destRow, destCol);
    }

}
