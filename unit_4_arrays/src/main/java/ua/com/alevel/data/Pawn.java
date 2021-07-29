package ua.com.alevel.data;

public class Pawn extends Figure {


    public Pawn(String startPosition, String currentPosition, Side side) {
        super(startPosition, currentPosition, side);
        //todo in figure constructor setChessman();
        setChessman();
    }

    @Override
    protected void setChessman() {
        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_PAWN;
        }else{
            this.chessman=Chessman.BLACK_PAWN;
        }
    }
}
