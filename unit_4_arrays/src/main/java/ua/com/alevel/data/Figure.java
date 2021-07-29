package ua.com.alevel.data;

//public abstract class Figure {
public abstract class Figure{

    protected Chessman chessman;
    protected String startPosition;
    protected String currentPosition;
    protected Side side;

    public Figure(String startPosition, String currentPosition, Side side){

        this.startPosition = startPosition;
        this.currentPosition = currentPosition;
        this.side = side;

    }

//todo moving for figures
//    moveTo();
//    ruleFor();

//
//    @Override
//    public String toString(){
//
//        return "Figure{" +
//                "chessman=" + chessman +
//                ", startPosition='" + startPosition + '\'' +
//                ", currentPosition='" + currentPosition + '\'' +
//                ", side=" + side +
//                '}';
//
//    }

    @Override
    public String toString(){

        return getChessman().getFigureUnicode() ;

    }

    public Chessman getChessman(){

        return chessman;
    }

    protected abstract void setChessman();

    public String getStartPosition(){

        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getCurrentPosition(){

        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition){

        this.currentPosition = currentPosition;
    }

    public Side getSide(){

        return side;
    }

    public void setSide(Side side){

        this.side = side;
    }


}