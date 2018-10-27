import javax.swing.*;
/*
import java.awt.Graphics;
import java.awt.Dimension;
*/
import java.awt.*;
import java.awt.geom.Ellipse2D;
public class AlgoFrame extends JFrame{
    private int canvasHeight;
    private int canvasWeight;

    public AlgoFrame(String title,int canvasHeight,int canvasWeight){
        super(title);
        this.canvasWeight = canvasWeight;
        this.canvasHeight = canvasHeight;

        //���ô��ڴ�С
       // setSize(canvasHeight,canvasWeight);
        //���JPanel
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        //ʹJFrame��ӦJPanel�Ĵ�С
        pack();
        //�̶�����
        setResizable(false);
         //����رհ�ť
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ӻ�
        setVisible(true);

    }

    //�ٶ���һ���򵥵Ĺ��캯��
    public AlgoFrame(String title){
        this(title,1024,768);
    }

    public int getCanvasHeight(){
        return canvasHeight;
    }

    public int getCanvasWeight(){
        return canvasWeight;
    }


    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;
        //JFrame���»������
        repaint();
    }

    //���û���
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            //����˫����
            super(true);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //ʹ��Graphics2D
            Graphics2D g2d = (Graphics2D)g;

            //�����
            RenderingHints hints = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON
                                    );
            g2d.addRenderingHints(hints);

            //�������
            AlgoViHelper.setStroke(g2d,1);
            AlgoViHelper.setColor(g2d,Color.RED);
            //================��Ҫע��Ĳ���=================
            for(Circle circle: circles){
                //�����Ƿ����
                if(!circle.isFilled)
                    AlgoViHelper.drawCircle(g2d,circle.x,circle.y,circle.getR());
                else
                    AlgoViHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());
            }
        }

        //===================================================================

        //��ʼ��ʱ�ᱻ���ã�����JPanel�Ĵ�С
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasHeight,canvasWeight);
        }

    }
}
