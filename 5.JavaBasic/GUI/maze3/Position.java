public class Position{
    private int x,y;
    private Position prev;
    public Position(int x,int y,Position pos){
        this.x = x;
        this.y = y;
        this.prev = pos;
    }
    public Position(int x,int y){
        this(x,y,null);
    }

    public int getX(){ return x;}
    public int getY(){ return y;}
    public Position getPrev(){ return prev;}
}
