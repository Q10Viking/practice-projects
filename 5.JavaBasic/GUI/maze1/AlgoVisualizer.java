import java.awt.*;
public class AlgoVisualizer{
    private static int blockSize=6;
    private static int DELAY=10;
    private MazeData maze;
    private AlgoFrame frame;
    //一个位置的四个方向
    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
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
        setData(-1,-1,false);
        if(!go(maze.getEntranceX(),maze.getEntranceY())){
            System.out.println("The maze has no solution.");
        }
        setData(-1, -1, false);

    }
    //递归遍历图
    private boolean go(int x,int y){
        maze.visited[x][y]=true;
        setData(x,y,true);
        if(x == maze.getExitX() && y == maze.getExitY())
            return true;
        for(int i=0;i<4;i++){
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(maze.inArea(newX,newY)
                    && !maze.visited[newX][newY]
                    && maze.getMaze(newX,newY) == MazeData.ROAD)
                if(go(newX,newY))
                    return true; //在这里截断不进行visisted的取消，只保留着正确的路径
        }
        //回溯将之前标记的撤销
        setData(x,y,false);
        return false;
    }


    private void setData(int x,int y,boolean isPath){
        if(maze.inArea(x,y))
            maze.path[x][y] = isPath;
        frame.render(maze);
        AlgoHelper.pause(DELAY);
    }
}
