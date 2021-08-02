package ua.com.alevel.data;

public class Knight extends Figure{

    private static final int CELLS_IN_L_FIGURE_BODY = 2;
    private static final int CELLS_IN_L_FIGURE_TOP = 1;

    public Knight(String startPosition,  Side side){

        super(startPosition, side);
    }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_KNIGHT;
        }else{
            this.chessman=Chessman.BLACK_KNIGHT;
        }
    }

    @Override
    public boolean isMoveValidByFigureRules(int srcRow, int srcCol, int destRow, int destCol){

        int difRow = Math.abs(destRow - srcRow);
        int difCol = Math.abs(destCol - srcCol);
        if( (difRow == CELLS_IN_L_FIGURE_BODY && difCol == CELLS_IN_L_FIGURE_TOP) ||
                (difRow == CELLS_IN_L_FIGURE_TOP && difCol == CELLS_IN_L_FIGURE_BODY)){

            this.isEnemyKingBeaten(destRow, destCol);
            return true;
        }else{

            System.out.println("This figure moves by another rules");
            return false;
        }

    }

}
