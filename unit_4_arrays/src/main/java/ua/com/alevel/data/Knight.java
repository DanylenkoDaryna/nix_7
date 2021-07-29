package ua.com.alevel.data;

public class Knight extends Figure{

    public Knight(String startPosition, String currentPosition, Side side){
        super(startPosition, currentPosition, side);
        setChessman();
    }

    @Override
    protected void setChessman(){

        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_KNIGHT;
        }else{
            this.chessman=Chessman.BLACK_KNIGHT;
        }
    }
}
