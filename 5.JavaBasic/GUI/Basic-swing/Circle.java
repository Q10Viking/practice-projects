import java.awt.Point;
public class Circle{
    //圆心
    public int x,y;
    //半径
    private int r;
    //运动速度
    public int vx,vy;
    public boolean isFilled = false;
    public Circle(int x,int y,int r,int vx,int vy){
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR(){
        return r;
    }
    //移动
    public void move(int minx,int miny,int maxx,int maxy){
        x += vx;
        y += vy;
        checkCollision(minx,miny,maxx,maxy);
    }

    //简单的检测碰撞
    private void checkCollision(int minx,int miny,int maxx,int maxy){
        if(x-r<minx){ x=r; vx = -vx;}
        if(y-r<miny){ y=r; vy = -vy;}
        if(x+r>=maxx){ x=maxx-r; vx = -vx;}
        if(y+r>=maxy){ y=maxy-r; vy = -vy;}
    }

    public boolean contains(Point p){
        return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)<=r*r;
    }
}
