import java.awt.*;
import javax.swing.*;
public class AlgoVisualizer{
    private static final int BLOCKSIZE = 6;
    private MazeData maze;
    private AlgoFrame frame;

    public AlgoVisualizer(int n,int m){
        maze = new MazeData(n,m);
        int sceneWidth = BLOCKSIZE*m;
        int sceneHeight = BLOCKSIZE*n;
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Maze Generalization",sceneWidth,sceneHeight);

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
    }


}
