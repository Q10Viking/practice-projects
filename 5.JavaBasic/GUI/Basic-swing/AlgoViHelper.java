import java.awt.*;
import java.awt.geom.Ellipse2D;
public class AlgoViHelper{
    //不希望外界创建这个对象
    private AlgoViHelper(){}

    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    public static void drawCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,r*2,r*2);
        g2d.draw(circle);
    }

    public static void setStroke(Graphics2D g2d,int w){
        //设置线条的末端形状，折现的拐角形状
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,r*2,r*2);
        g2d.fill(circle);
    }

    //为了使得Main程序中代码简洁些，将异常处理放到另外一个函数进行处理
    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch(InterruptedException e){
            System.out.println("Error sleeping.");
        }
    }
}
