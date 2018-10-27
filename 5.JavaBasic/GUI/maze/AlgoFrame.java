import javax.swing.*;
import java.awt.*;
public class AlgoFrame extends JFrame{
    private int canvasWidth;
    private int canvasHeight;

    private MazeData maze;
    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        //setSize(canvasWidth,canvasHeight);
        //通过JPanel的大小来决定整个窗口的大小
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getCanvasHeight(){
        return canvasHeight;
    }
    public int getCanvasWidth(){
        return canvasWidth;
    }

    public void render(MazeData maze){
        this.maze = maze;
        repaint();
    }

    private class AlgoCanvas extends JPanel{
        public AlgoCanvas(){
            //开启双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON
                                 );
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);



            //进行绘制

            int w = canvasWidth / maze.getM();
            int h = canvasHeight / maze.getN();

            for(int i=0;i<maze.getN();i++){
                for(int j=0;j<maze.getM();j++){
                    //设置绘制的颜色，墙用蓝色，路用白色
                    if(maze.getMaze(i,j) == MazeData.WALL)
                        AlgoHelper.setColor(g2d,AlgoHelper.LightBlue);
                    else
                        AlgoHelper.setColor(g2d,AlgoHelper.White);

                    AlgoHelper.fillRectangle(g2d,j*w,i*h,w,h);

                }
            }

        }

        //确定了JPanel的大小
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
