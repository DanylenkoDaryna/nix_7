package ua.com.alevel.data;

public class Bishop extends Figure {

    public Bishop(String startPosition, String currentPosition, Side side) {
        super(startPosition, currentPosition, side);
        setChessman();
    }

    @Override
    protected void setChessman() {
        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_BISHOP;
        }else{
            this.chessman=Chessman.BLACK_BISHOP;
        }
    }
}
