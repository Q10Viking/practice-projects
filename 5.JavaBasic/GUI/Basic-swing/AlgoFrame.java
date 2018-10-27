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

        //设置窗口大小
       // setSize(canvasHeight,canvasWeight);
        //添加JPanel
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        //使JFrame适应JPanel的大小
        pack();
        //固定窗口
        setResizable(false);
         //激活关闭按钮
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //可视化
        setVisible(true);

    }

    //再定义一个简单的构造函数
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
        //JFrame重新绘制组件
        repaint();
    }

    //设置画布
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            //开启双缓存
            super(true);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //使用Graphics2D
            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON
                                    );
            g2d.addRenderingHints(hints);

            //具体绘制
            AlgoViHelper.setStroke(g2d,1);
            AlgoViHelper.setColor(g2d,Color.RED);
            //================需要注意的部分=================
            for(Circle circle: circles){
                //设置是否填充
                if(!circle.isFilled)
                    AlgoViHelper.drawCircle(g2d,circle.x,circle.y,circle.getR());
                else
                    AlgoViHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());
            }
        }

        //===================================================================

        //初始化时会被调用，设置JPanel的大小
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasHeight,canvasWeight);
        }

    }
}
