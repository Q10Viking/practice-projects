import java.awt.*;
import java.awt.geom.Ellipse2D;
public class AlgoViHelper{
    //��ϣ����紴���������
    private AlgoViHelper(){}

    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    public static void drawCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,r*2,r*2);
        g2d.draw(circle);
    }

    public static void setStroke(Graphics2D g2d,int w){
        //����������ĩ����״�����ֵĹս���״
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,r*2,r*2);
        g2d.fill(circle);
    }

    //Ϊ��ʹ��Main�����д�����Щ�����쳣����ŵ�����һ���������д���
    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch(InterruptedException e){
            System.out.println("Error sleeping.");
        }
    }
}
