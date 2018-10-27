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
        //ͨ��JPanel�Ĵ�С�������������ڵĴ�С
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
            //����˫����
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            //�����
            RenderingHints hints = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON
                                 );
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);



            //���л���

            int w = canvasWidth / maze.getM();
            int h = canvasHeight / maze.getN();

            for(int i=0;i<maze.getN();i++){
                for(int j=0;j<maze.getM();j++){
                    //���û��Ƶ���ɫ��ǽ����ɫ��·�ð�ɫ
                    if(maze.getMaze(i,j) == MazeData.WALL)
                        AlgoHelper.setColor(g2d,AlgoHelper.LightBlue);
                    else
                        AlgoHelper.setColor(g2d,AlgoHelper.White);

                    AlgoHelper.fillRectangle(g2d,j*w,i*h,w,h);

                }
            }

        }

        //ȷ����JPanel�Ĵ�С
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
