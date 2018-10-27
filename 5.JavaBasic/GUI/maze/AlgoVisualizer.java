import java.awt.*;
public class AlgoVisualizer{
    //��Ԫ�ĺ��
    private static int blockSize=6;
    private static int DELAY=20;
    private MazeData maze;
    private AlgoFrame frame;

    public AlgoVisualizer(String filename){
        maze = new MazeData(filename);
        int sceneHeight = maze.getN()*blockSize;
        int sceneWidth = maze.getM()*blockSize;

        //��ʼ����ͼ
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Maze Solver Visualization",sceneWidth,sceneHeight);

            new Thread(()->{
                run();
            }).start();

        });
    }

    private void run(){
        setData();
    }

    private void setData(){
        frame.render(maze);
        AlgoHelper.pause(DELAY);
    }
}
