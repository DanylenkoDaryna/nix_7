package ua.com.alevel.data;

public class King extends Figure {


    public King(String startPosition, String currentPosition, Side side) {
        super(startPosition, currentPosition, side);
        setChessman();
    }

    @Override
    protected void setChessman() {
        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_KING;
        }else{
            this.chessman=Chessman.BLACK_KING;
        }
    }
}
