package ua.com.alevel.data;

public class Queen extends Figure {

    public Queen(String startPosition, String currentPosition, Side side) {
        super(startPosition, currentPosition, side);
        setChessman();
    }

    @Override
    protected void setChessman() {
        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_QUEEN;
        }else{
            this.chessman=Chessman.BLACK_QUEEN;
        }
    }
}
