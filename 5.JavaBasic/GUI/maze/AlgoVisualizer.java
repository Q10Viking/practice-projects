import java.awt.*;
public class AlgoVisualizer{
    //单元的厚度
    private static int blockSize=6;
    private static int DELAY=20;
    private MazeData maze;
    private AlgoFrame frame;

    public AlgoVisualizer(String filename){
        maze = new MazeData(filename);
        int sceneHeight = maze.getN()*blockSize;
        int sceneWidth = maze.getM()*blockSize;

        //初始化视图
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
