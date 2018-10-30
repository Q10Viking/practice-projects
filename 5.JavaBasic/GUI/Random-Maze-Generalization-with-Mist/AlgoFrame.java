import java.awt.*;
import javax.swing.*;

public class AlgoFrame extends JFrame{
    private int canvasHeight,canvasWidth;
    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private MazeData mazeData;
    public void render(MazeData maze){
        mazeData = maze;
        repaint();
    }

    private class AlgoCanvas extends JPanel{
        public AlgoCanvas(){
            //À´ª∫¥Ê
            super(true);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //…Ë÷√øπæ‚≥›
            RenderingHints hints = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            int w = (int)canvasWidth/mazeData.getM();
            int h = (int)canvasHeight/mazeData.getN();
            //ªÊ÷∆Õº–Œ
            for(int i=0;i<mazeData.getN();i++)
                for(int j=0;j<mazeData.getM();j++){
                    if(mazeData.inMist[i][j])
                        AlgoHelper.setColor(g2d,AlgoHelper.Black);
                    else if(mazeData.getMaze(i,j)==MazeData.ROAD)
                        AlgoHelper.setColor(g2d,AlgoHelper.White);
                    else
                        AlgoHelper.setColor(g2d,AlgoHelper.LightBlue);

                    AlgoHelper.fillRectangle(g2d,j*w,i*h,w,h);
                }


        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
