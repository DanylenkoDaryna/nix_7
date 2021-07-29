package ua.com.alevel.data;

public class Rook extends Figure{


    public Rook(String startPosition, String currentPosition, Side side){
        super(startPosition, currentPosition, side);
        setChessman();
    }

    @Override
    protected void setChessman(){
        if(getSide().equals(Side.WHITES)){
            this.chessman=Chessman.WHITE_ROOK;
        }else{
            this.chessman=Chessman.BLACK_ROOK;
        }
    }
}
