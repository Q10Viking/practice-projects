import java.awt.Point;
public class Circle{
    //Բ��
    public int x,y;
    //�뾶
    private int r;
    //�˶��ٶ�
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
    //�ƶ�
    public void move(int minx,int miny,int maxx,int maxy){
        x += vx;
        y += vy;
        checkCollision(minx,miny,maxx,maxy);
    }

    //�򵥵ļ����ײ
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
